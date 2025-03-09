# https://leetcode.com/problems/two-sum
# Brute Force Solution
# TC: O(n^2) | SC: O(1)

from typing import List
from leetcode.array_and_hashing.two_sum import TEST_CASE

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Given an array of integers nums and an integer target, 
        return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        """

        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []
    
# Test cases
def test():
    # test_suites = JSONUtil.from_json_file("./leetcode/array_and_hashing/1_Two_Sum/test_cases.json")
    sol =  Solution()
    for i, test_suite in enumerate(TEST_CASE):
        try:
            assert sol.twoSum(**test_suite["input"]) == test_suite["expected"]
            print(f"Test case {i+1}: Passed")
        except AssertionError:
            print(f"Test case {i+1}: Failed | Input: {test_suite['input']} | Expected: {test_suite['expected']}")


if __name__ == "__main__":
    test()