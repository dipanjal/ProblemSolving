package com.dipanjal.leetcode.easy;

/**
 * @author dipanjal
 * @since 0.0.1
 * 53. Maximum Sum of Contiguous Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    // TC: O(n3)
    public static int maxSubArray(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++){
//            System.out.println(String.format("[i = %d]", i));
            for(int j=i; j<nums.length; j++){
//                System.out.println(String.format("\t[j = %d]", j));
                int sum = 0;
                for(int k=i; k<=j; k++){
//                    System.out.println(String.format("\t\t[k[%d] = %d]", k, nums[k]));
                    sum += nums[k];
                }
//                System.out.println(String.format("\t\tsum = %d", sum));

                max = Math.max(sum, max);
            }
        }
        return max;
    }

    // TC: O(n2)
    public static int maxSubArray2(int[] nums) {
        int max = 0; // Initialise the variable with minimum integer value

        // i will be the starting index of subarray
        for(int i=0; i<nums.length; i++){

            int sum = 0;

            // j will be the ending index of subarray
            for(int j=i; j<nums.length; j++){
                // Add the current element to previous computed value
                // To get the subarray sum
                sum += nums[j];

                // Does this window beat the best sum we have seen so far?
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    /**
     * Kadane's Algorithm
     * Time Complexity: O(n)
     * explanation: https://www.youtube.com/watch?v=jnoVtCKECmQ
     */
    public static int maxSubArray3(int[] nums) {
        int maxSum = nums[0];
        int currentMaxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            maxSum = Math.max(currentMaxSum, maxSum);
        }
        return maxSum;
    }

    /**
     * Kadane's Algorithm
     * Time Complexity: O(n)
     * explanation: https://www.youtube.com/watch?v=jnoVtCKECmQ
     */
    public static int maxSubArray4(int[] nums) {
        int maxSum = nums[0];
        int currentMaxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            maxSum = Math.max(currentMaxSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {5,4,-11,7,8};
        int[] nums = {-2, 1, 3};
        System.out.println("Max Sum: "+ maxSubArray3(nums));
    }
}
