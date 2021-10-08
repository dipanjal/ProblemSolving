package com.dipanjal.educative.slidingwindow;

public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {

        int minWinLen = Integer.MAX_VALUE,
                winSum = 0,
                winStart = 0;

        for(int winEnd=0; winEnd<arr.length; winEnd++) {
            winSum += arr[winEnd];

            while(winSum >= S) {
                minWinLen = Math.min(minWinLen, (winEnd - winStart + 1));
                winSum -= arr[winStart++];
            }
        }
        return minWinLen == Integer.MAX_VALUE ? 0 : minWinLen;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
    }
}
