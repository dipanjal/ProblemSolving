// Leeocode 287 | Find the Duplicate Number
// Problem: https://leetcode.com/problems/find-the-duplicate-number/description/
// Difficulty: Medium
// Editorial: TBA
// Video Explanation: https://youtu.be/H-9XTaM22bo

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}