from typing import List

# https://leetcode.com/problems/house-robber/
# 198. House Robber
# Tabulatio | Iterative | Bottom Up | Dynamic Programming
# Time Complexity: O(n) -> linear: because we are computing the result for each house only once
# Space Complexity: O(n) -> using array to save the max profit we can get from each houses
class Solution:
    def rob(i: int, nums: List[int]) -> int:
        # handle edge cases first
        if len(nums) == 1:
            return nums[0]
        # now create a dp array to store max profits form each houses
        maxProfits = [0] * len(nums)
        
        # seed with base results
        # base case: if the current house index is 0
        # to maximize the profit, return the amount of money in the house at index 0
        maxProfits[0] = nums[0]
        # base case: if the current house index is 1
        # return max amount between house at index 0 and house at index 1
        # we are handling index 1 to prevent the array index going bellow 0 (i.e. out of lower bound)
        maxProfits[1] = max(nums[0], nums[1])
        # done with our first two indexes
        # start with index 2
        for i in range(2, len(nums)):
            # now we have two options
            # either we can rob the house and go for house at 2 index previous from the current house
            # because we can not rob adjacent houses
            # collect money from current house + rob house at 2 index previous
            robbed = nums[i] + maxProfits[i-2]
            
            # skip the current house and go for the previous adjacent house
            skipped = 0 + maxProfits[i-1]
            
            # save max profit for current house by selecting max amount between these two results
            maxProfits[i] = max(robbed, skipped)
        
        # finally return the last value which is the ultimate max amount
        return maxProfits[len(nums) - 1]

if __name__ == "__main__":
    test_suites = [
        {"input": [2, 1, 4, 9], "expected": 11},
        {"input": [1,2,3,1], "expected": 4},
        {"input": [2,7,9,3,1], "expected": 12},
        {"input": [1, 1], "expected": 1},
        {"input": [0], "expected": 0},
        {
            "input": [104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143],
            "expected": 3176
        },
        {
            "input": [114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240],
            "expected": 4173
        }
    ]

    sol =  Solution()
    for suite in test_suites:
        if suite.get("skip", False):
            print("Test Skipped")
            continue
        actual = sol.rob(suite['input'])
        if actual == suite['expected']:
            print("Test Passed")
        else:
            print(f"Test Failed: Expected {suite['expected']}, Actual {actual}")