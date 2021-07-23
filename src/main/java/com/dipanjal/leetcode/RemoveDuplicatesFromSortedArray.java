package com.dipanjal.leetcode;

import java.util.Arrays;

/**
 * @author dipanjal
 * @since 0.0.1
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Difficulty: Easy
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int slowIndex = 0;
        for(int fastIndex=1; fastIndex<nums.length; fastIndex++)
            if(nums[slowIndex]  != nums[fastIndex])
                nums[++slowIndex] = nums[fastIndex];

        return slowIndex+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums)
                .forEach(System.out::println);
    }
}
