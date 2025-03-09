# https://leetcode.com/problems/two-sum
# Hashing Solution (Optimized)
# TC: O(n) 
# SC: O(1) because we are using a dictionary to store the indices of the elements

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Given an array of integers nums and an integer target, 
        return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        """
        
        visited: dict[int, int] = {} # store the indices of the nums
        for i in range(len(nums)):
            rem: int = target - nums[i]  # this means rem + nums[i] = target
            
            # and if we have already visited the rem, then we have found the pair
            if rem in visited:
                return [visited[rem], i] # return the indices of the pair
            
            # otherwise, store the index of the current element for future iterations
            visited[nums[i]] = i
        return []
    
# Test cases
def test():
    test_suites = [
        {
            "input": {"nums": [2, 7, 11, 15], "target": 9},
            "expected": [0, 1]
        },
        {
            "input": {"nums": [3, 2, 4], "target": 6},
            "expected": [1, 2]
        },
        {
            "input": {"nums": [3, 3], "target": 6},
            "expected": [0, 1]
        }
    ]
    sol =  Solution()
    for i, test_suite in enumerate(test_suites):
        try:
            assert sol.twoSum(**test_suite["input"]) == test_suite["expected"]
            print(f"Test case {i+1}: Passed")
        except AssertionError:
            print(f"Test case {i+1}: Failed | Input: {test_suite['input']} | Expected: {test_suite['expected']}")


if __name__ == "__main__":
    test()