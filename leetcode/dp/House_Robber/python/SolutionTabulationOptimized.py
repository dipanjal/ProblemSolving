from typing import List

# https:#leetcode.com/problems/house-robber/
# 198. House Robber
# Prerequisite: we must understand tabulation approach first
# Tabulation + Space Optimized | Iterative Approach | Bottom Up | Dynamic Programming
# Time Complexity: O(n) -> linear: because we are computing the result for each house only once
# Space Complexity: O(1) -> track result of previous 2 houses using 2 variables
class Solution:
    def rob(i: int, nums: List[int]) -> int:
        # handle edge cases first
        if len(nums) == 1:
            return nums[0]
        # instead of an dp array we will use two variables 
        # to keep track of the result of previous two houses
        # assume this is max profit for house at index 0
        prev2 = nums[0]
        # assume this is max profit for house at index 1
        prev1 = max(nums[0], nums[1])
        # let's start from index 2
        for i in range(2, len(nums)):
            # rob the current house + add profit from 2 house back (non adj)
            robbed = nums[i] + prev2

            # skip current house and rob adj house
            skipepd = 0 + prev1

            # find the maximum between them
            currMax = max(robbed, skipepd)

            # track the result of current house and previous
            prev2, prev1 = prev1, currMax
        
        # return the last value which is the ultimate result
        return prev1
    
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