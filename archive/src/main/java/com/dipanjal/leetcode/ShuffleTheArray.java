package com.dipanjal.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 1470. Shuffle the Array
 * url: https://leetcode.com/problems/shuffle-the-array/
 * easy
 */
public class ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        int limit = nums.length/2;
        int resIndex = 0;
        for(int i=0; i<limit; i++) {
            result[resIndex++] = nums[i];
            result[resIndex++] = nums[i + n];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,5,1,3,4,7};
        String s = Arrays.stream(shuffle(nums, 3))
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }
}
