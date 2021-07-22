package com.dipanjal.leetcode.easy;

/**
 * @author dipanjal
 * @since 0.0.1
 */

/*
643. Maximum Average Subarray I
url: https://leetcode.com/problems/maximum-average-subarray-i/

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value
and return this value. Any answer with a calculation error less than 10^-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */

public class MaxSubArr1 {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for(int i=0; i<k; i++)
            sum+=nums[i];

        double max = sum;

        for(int i = k; i<nums.length; i++){
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(max, sum);
        }

        return max/k;
    }


    public static void main(String[] args) {
        int[] nums = {0,4,0,3,2};
        int k = 1;

        System.out.println(findMaxAverage(nums, k));
    }
}
