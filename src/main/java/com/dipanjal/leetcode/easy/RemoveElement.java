package com.dipanjal.leetcode.easy;

import java.util.Arrays;

/**
 * @author dipanjal
 * @since 0.0.1
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 * Difficulty: Easy
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int lengthCounter = 0;
        for(int i=0; i<nums.length; i++)
            if(nums[i]  != val)
                nums[lengthCounter++] = nums[i];

        return lengthCounter;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums, 3));
        Arrays.stream(nums)
                .forEach(System.out::println);
    }
}
