package com.dipanjal.educative.slidingwindow;

public class MaximumSumSubareaSizeK {

    /**
     * k = window size
     * n = size of array
     * Time Complexity O(n * k)
     * Space Complexity = O(n)
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        int maxSum = 0;
        int end = arr.length - k;
        for (int i=0; i<=end; i++) {
            int windowEnd = (i+k) - 1;
            int windowSum = 0;
            for(int j=i; j<=windowEnd; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    /**
     * k = window size
     * n = size of array
     *
     * Better Approach, we are not gonna re-calculate the overlapping elements
     * Once the K size has reached, we are going to slide the windows,
     * As the window slides, one time will go out of the windows and another item is adding into the window
     * we have our window sum, so the idea is (windowSum - outgoing item) + newly added item
     *
     * Time Complexity = O(n)
     * Space Complexity = O(n)
     */
    public static int findMaxSumSubArray2(int k, int[] arr) {
        int maxSum = 0, winSum = 0, winStart = 0;
        for(int winEnd=0; winEnd<arr.length; winEnd++) {
            winSum += arr[winEnd];
            if(winEnd >= k - 1) {
                maxSum = Math.max(winSum, maxSum);
                winSum -= arr[winStart++];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));

        System.out.println(findMaxSumSubArray2(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(findMaxSumSubArray2(2, new int[]{2, 3, 4, 1, 5}));
    }
}
