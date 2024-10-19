from utils import log_execution_time

# Recursive Solution | Top Down Brute Force
# TC: O(2^n) because every index exploring 2 possibilities [pick or not-pick]
# SC: O(n) where n is the depth of recursion call stack
class SolutionRecur:
    def get_max_sum(self, nums: list[int]):
        def max_sum(i):
            if (i < 0):
                # index already gone out of bound
                return 0
            if (i == 0):
                # that means index 1 is not taken and 0th index is our first picked index
                # we can return what's in index 0 to maximize the sum
                return nums[0]
            pick = nums[i] + max_sum(i-2)
            not_pick = 0 + max_sum(i-1)
            return max(pick, not_pick)
        
        # starting from the top
        return max_sum(len(nums) - 1)

# Recursive Memoization Solution | Top Down Optimized
# TC: O(n)
# SC: O(n) + O(n) where n is the depth of recursion call stack and O(n) is the memoization array
class SolutionMemoization:
    def get_max_sum(self, nums: list[int]):
        memo = {}
        def max_sum(i):
            if (i < 0):
                # index already gone out of bound
                return 0
            if (i == 0):
                # that means index 1 is not taken and 0th index is our first picked index
                # we can return what's in index 0 to maximize the sum
                return nums[0]
            
            # if the result is already computed, return it without computing again
            if i in memo:
                return memo[i]
            else:
                # pick the current element and add the max sum of non-adjacent previous 2 index
                pick = nums[i] + max_sum(i - 2)
                # not pick the current element and add the max sum of previous index
                not_pick = 0 + max_sum(i - 1)
                # store the max value of pick and not_pick in the memo
                memo[i] = max(pick, not_pick)
                # return the max value from the memo
                return memo[i]
            
        # starting from the top
        return max_sum(len(nums) - 1)

# Tabulation Solution | Bottom Up
# TC: O(n)
# SC: O(n) where n is the size of the tabulation array
class SolutionTabulation:
    def get_max_sum(self, nums: list[int]):
        # handle edge cases
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        # initialize the max_sum array with 0s
        max_sum = [0] * len(nums)
        # the max sum of 0th index is the value at 0th index
        max_sum[0] = nums[0]
        # the max sum of 1st index is the max of 0th and 1st index
        max_sum[1] = max(nums[0], nums[1])
        # iterate from 2nd index to the end
        for i in range(2, len(nums)):
            # either pick the current element and add the max sum of non-adjacent previous 2 index
            pick = nums[i] + max_sum[i-2]
            # or not pick the current element, just keep the max sum of previous index
            not_pick = 0 + max_sum[i-1]
            # store the max value of pick and not_pick in the current index
            max_sum[i] = max(pick, not_pick)
        
        # return the max sum of the last index
        # because as we computed and moved from 0 to n-1, 
        # the last index will have the max sum of non-adjacent subsequence
        return max_sum[len(nums) - 1]

# Tabulation Solution | Bottom Up Optimized
# TC: O(n)
# SC: O(1) keeping only 2 variables to store the previous 2 max sums
class SolutionTabulationOptimized:
    def get_max_sum(self, nums: list[int]):
        # handle edge cases
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
            
        # initialize the previous 2 max sums
        prev = nums[0]
        curr = max(nums[0], nums[1])
        # iterate from 2nd index to the end
        for i in range(2, len(nums)):
            # either pick the current element and add the max sum of non-adjacent previous 2 index
            taken = nums[i] + prev
            # or not pick the current element, just keep the max sum of previous index
            not_taken = 0 + curr
            # store the max value of pick and not_pick in a variable
            max_sum = max(taken, not_taken)
            # update the previous 2 max sums
            prev, curr = curr, max_sum
        return curr



# executor codes
@log_execution_time
def exec_recur(test_suites: list[dict]):
    print("-------- Recursive Solution Start -----------")
    s = SolutionRecur()
    for suite in test_suites:
        actual = s.get_max_sum(suite['input'])
        print(f"input: {suite['input']} | max sum = {actual}")
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")
    print("-------- Recursive Solution End -----------")

@log_execution_time
def exec_memo(test_suites: list[dict]):
    print("-------- Recursive Memoization Solution Start -----------")
    s = SolutionMemoization()
    for suite in test_suites:
        actual = s.get_max_sum(suite['input'])
        print(f"input: {suite['input']} | max sum = {actual}")
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")
    print("-------- Recursive Memoization Solution End -----------")


@log_execution_time
def exec_tabulation(test_suites: list[dict]):
    print("-------- Tabulation Solution Start -----------")
    s = SolutionTabulation()
    for suite in test_suites:
        actual = s.get_max_sum(suite['input'])
        print(f"input: {suite['input']} | max sum = {actual}")
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")
    print("-------- Tabulation Solution End -----------")


@log_execution_time
def exec_tabulation_optimized(test_suites: list[dict]):
    print("-------- Tabulation Optimized Solution Start -----------")
    s = SolutionTabulationOptimized()
    for suite in test_suites:
        actual = s.get_max_sum(suite['input'])
        print(f"input: {suite['input']} | max sum = {actual}")
        assert actual == suite['expected'], f"expected: {suite['expected']} got: {actual}"
    print("All assertions passed")
    print("-------- Tabulation Optimized Solution End -----------")


def main():
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
    
    # exec_recur(test_suites)
    exec_memo(test_suites)
    exec_tabulation(test_suites)
    exec_tabulation_optimized(test_suites)

if __name__ == "__main__":
    main()
