from typing import List
from utils import log_execution_time

# https://leetcode.com/problems/house-robber/
# 198. House Robber

# Recursion # Top-Down
# Difficulty: Medium
# TC: O(2^n) because for each house we have 2 choices, either rob or not rob
# SC: O(n) because of the recursion stack
class SolutionRecur:
    def rob(self, nums: List[int]) -> int:
        def dfs(i: int) -> int:
            if i < 0:
                return 0
            if i == 0:
                return nums[0]
            # choice 1: rob the current house and skip the next house
            robbed = nums[i] + dfs(i - 2)
            # choice 2: skip the current house and rob the next house
            skip = 0 + dfs(i - 1)
            # return the max value of rob and skip
            return max(robbed, skip)
        # start from the last house and move towards the first house
        return dfs(len(nums) - 1)

# Recursion + Memoization # Top-Down # Dynamic Programming
# Difficulty: Medium

# TC: O(n) 
# because each index is computed only once and stored in memo
# After the first computation, subsequent calls for the same index
# will return the memoized result in O(1) time, effectively reducing
# the time complexity from O(2^n) to O(n)

# SC: O(n) + O(n) because of the recursion stack + memoization
class SolutionMemo:
    def rob(self, nums: List[int]) -> int:
        # handle edge cases first
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])

        # initialize the memo with base cases
        memo = {0: nums[0], 1: max(nums[0], nums[1])}
        def dfs(i: int) -> int:
            # if max sum for current index is already computed, return it without recomputing
            if i in memo:
                return memo[i]
            # otherwise, compute the max sum for the current index
            else:
                # we have 2 choices:
                # choice 1: rob the current house and skip the next house
                robbed = nums[i] + dfs(i - 2)
                # choice 2: skip the current house and rob the next house
                skip = 0 + dfs(i - 1)
                # store the max profit of rob and skip in the memo
                memo[i] = max(robbed, skip)
                return memo[i]
        
        # start from the last house and move towards the first house
        return dfs(len(nums) - 1)

# Iterative # Tabulation # Bottom-Up # Dynamic Programming
# Difficulty: Medium
# TC: O(n)
# SC: O(1)
class SolutionTabulation:
    def rob(self, nums: List[int]) -> int:
        # handle edge cases first
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        # initialize the max profit array with size of nums
        # this array will store the max profit for robbing non-adjacent houses
        max_profit = [0] * len(nums)
        # base cases
        max_profit[0] = nums[0]
        max_profit[1] = max(nums[0], nums[1])
        
        # fill the max profit array for the rest of the houses
        # starting from the 3rd house, because we already have the max profit calculated for the first 2 houses
        for i in range(2, len(nums)):
            # like recursion, we have 2 choices:
            
            # choice 1: rob the current house and skip the next house
            # pick the current house's money + money from 2 houses before
            # because we can't rob adjacent houses
            robbed = nums[i] + max_profit[i-2]  
            
            # choice 2: skip the current house and rob the next house
            # skip the current house and take the money from the previous house
            skip = 0 + max_profit[i-1]


            # have you noticed why we are taking profit from the previous house?
            # because we are iterating from the 3rd house to the last house 
            # and we already have the max profit calculated for the first 2 houses
            
            
            # Have you noticed another thing, 
            # that we are only tracking max profit of just two previous houses?
            # it's because we can't rob adjacent houses
            # so can we optimize the space complexity?


            # store the max profit of rob and skip in the max profit array
            max_profit[i] = max(robbed, skip)
        
        # return the max profit for the last house
        # because max profits are being accumulated from 0th index to the last index in this array
        return max_profit[len(nums) - 1]


# Iterative # Tabulation Space Optimized # Bottom-Up # Dynamic Programming
# Difficulty: Medium
# TC: O(n)
# SC: O(1)
class SolutionSpaceOptimized:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        # initialize the max profit for the first 2 houses
        prev2 = nums[0]
        prev1 = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            # choice 1: rob the current house and skip the next house
            # pick the current house's money + money from 2 houses before
            # because we can't rob adjacent houses
            robbed = nums[i] + prev2

            # choice 2: skip the current house and rob the next house
            # skip the current house and take the money from the previous house
            skip = 0 + prev1

            # update the max profit for the current house
            prev2, prev1 = prev1, max(robbed, skip)
        
        # return the max profit for the last house
        return prev1
    

# Execution Related Codes

@log_execution_time
def exec_recur(test_suites):
    sol = SolutionRecur()
    for suite in test_suites:
        actual = sol.rob(suite['input'])
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")

@log_execution_time
def exec_memo(test_suites):
    sol = SolutionMemo()
    for suite in test_suites:
        actual = sol.rob(suite['input'])
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")

@log_execution_time
def exec_tabulation(test_suites):
    sol = SolutionTabulation()
    for suite in test_suites:
        actual = sol.rob(suite['input'])
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")

@log_execution_time
def exec_tabulation_optimized(test_suites):
    sol = SolutionSpaceOptimized()
    for suite in test_suites:
        actual = sol.rob(suite['input'])
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")

if __name__ == "__main__":
    test_suites = [
        {"input": [2, 1, 4, 9], "expected": 11},
        {"input": [1,2,3,1], "expected": 4},
        {"input": [2,7,9,3,1], "expected": 12},
        {
            "input": [104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143],
            "expected": 3176
        },
        {"input": [1, 1], "expected": 1},
        {"input": [0], "expected": 0},
    ]
    
    exec_recur(test_suites)
    exec_memo(test_suites)
    exec_tabulation(test_suites)
    exec_tabulation_optimized(test_suites)


