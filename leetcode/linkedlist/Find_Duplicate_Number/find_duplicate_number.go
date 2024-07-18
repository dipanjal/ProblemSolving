// Leeocode 287 | Find the Duplicate Number
// Problem: https://leetcode.com/problems/find-the-duplicate-number/description/
// Difficulty: Medium
// Editorial: TBA
// Video Explanation: https://youtu.be/H-9XTaM22bo

package main

func findDuplicate(nums []int) int {
	slow := nums[0]
	fast := nums[0]
	for true {
		slow = nums[slow]
		fast = nums[nums[fast]]
		if slow == fast {
			break
		}
	}
	slow2 := nums[0]
	for slow != slow2 {
		slow = nums[slow]
		slow2 = nums[slow2]
	}
	return slow
}
