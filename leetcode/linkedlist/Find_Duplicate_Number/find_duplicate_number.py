# Leeocode 287 | Find the Duplicate Number
# Problem: https://leetcode.com/problems/find-the-duplicate-number/description/
# Difficulty: Medium
# Editorial: TBA
# Video Explanation: https://youtu.be/H-9XTaM22bo

from typing import List

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # The trick lies between the array size and the choice of values could be in the array
        # the array size = N + 1 where the values must be starting from 1 to n inclusing
        # that means, if N + 1 = 6 the choice of the values in 1, 2, 3, 4 and 5
        # so there must be at least one duplicate numbers to fit with the array size
        # And there is only one repeated number in nums.

        # To solve this problem let's Treat the array as a linked list
        # where the values are pointers which is pointing to the another values in the array
        # because the value itself is the index of the another value
        # solving using the same technique we used for Linked List Cycle II

        # staring from head
        slow, fast = nums[0], nums[0]
        while True:
            slow = nums[slow] # ONE index at a time
            fast = nums[nums[fast]] # TWO Index at a time
            if slow == fast:
                break
        # we don't need to check hasCycle flag, because there always will be cycle.
        # Because there always will be one duplicate number in the array

        # at this point the slow and fast got meet with each other
        # that means they have intersected at a specific index (you may call it node)
        # according to floyed's tortoise and hare algorithm, 
        # the distance from head to the begining of the cycle is
        # equal to the distance from intersection point to the begining of the cycle

        curr = nums[0]
        while curr != slow:
            curr = nums[curr]
            slow = nums[slow]
        return curr