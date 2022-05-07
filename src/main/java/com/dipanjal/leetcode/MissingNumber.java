package com.dipanjal.leetcode;

import java.util.Arrays;

/**
 * @author dipanjal
 * @since 0.0.1
 */

/*
268. Missing Number
https://leetcode.com/problems/missing-number/
Difficulty: Easy
 */

public class MissingNumber {

    /**
     * Number Theory
     * Assume we have a range from [1 ... n] i.e: 1,2,3....n
     * we can sum all of them using a linear equation (n * n+1)/2
     */

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int rangeSum = (n * (n + 1))/2;
        return rangeSum - Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[]{0}));
    }


}
