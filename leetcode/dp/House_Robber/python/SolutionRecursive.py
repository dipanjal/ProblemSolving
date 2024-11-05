from typing import List

# https://leetcode.com/problems/house-robber/
# 198. House Robber
# Recursion | Top-Down | Brute Force
# Difficulty: Medium
# TC: O(2^n) because for each recursive call (i.e. each house) we have 2 choices, either rob or not rob
# SC: O(n) because of the recursion stack
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        # i = index of current house
        # nums = amount stashed in each houses
        def getMax(i: int) -> int:
            # we are using top down recursion, so we will always move in backward direction of the array
            # from the last house to 0th house

            # base case: when i=0 that means we would never rob index 1
            # so return money at house0 to maximize the profit
            if i == 0:
                return nums[0]
            
            # as we know we can't rob adj house
            # what if we are on index 1 and trying to find max profit from 2 house prev from index 1
            # 1 - 2 = -1 which is bellow 0 and out of bound, 
            # so we will consider index 1 as another base case
            if i == 1:
                return max(nums[0], nums[1])
            
            # now compute the others recersively, we have two options
            # we can either rob the current house + go for next non adjacent house (house 2 index back)
            robbed = nums[i] + getMax(i-2)
            # or we can skip the current house and rob the previous adjacent house
            skiped = 0 + getMax(i-1)
            # now maximize the outcome
            return max(robbed, skiped)
        
        # Top Down Recurison, staring from the last house
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
