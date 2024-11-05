from typing import List

# https://leetcode.com/problems/house-robber/
# 198. House Robber
# Recursive + Memoization | Top Down | Dynamic Programming
# Time Complexity: O(n) -> linear: because we are computing the result for each house only once
# Space Complexity: O(n) -> recursive stack space + O(n) -> memoization hashmap
class Solution:
    def rob(self, nums: List[int]) -> int:
        # handle edge cases first
        if len(nums) == 1:
            return nums[0]

        # initalizing memoization hashmap with base cases
        memo = {
            # when i=0 that means we can't rob house at index 1
            # return the amount from house at 0 to maximize the profit
            0: nums[0],
            # handling index 1 so the array index can never go bellow 0
            # and we know when we are at index 1, 
            # we have to take maximum between index 0 and 1
            1: max(nums[0], nums[1])
        }
        
        # i = index of current house
        def getMax(i: int) -> int:
            # return if already computer the result for current house
            if i in memo:
                return memo[i]
            else:
                # compute max profit from robbing or skipping current house
                # we can either rob the current house + go for next non adjacent house (house 2 index back)
                robbed = nums[i] + getMax(i-2)
                # or we can skip the current house and rob the previous adjacent house
                skipped = 0 + getMax(i-1)
                # now cache maximize the outcome then return
                # because of caching we wont need to recompute max profit for the same house over and over again
                memo[i] = max(robbed, skipped)
                return memo[i]
            
        return getMax(len(nums) - 1)

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