package com.dipanjal.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * medium
 */
public class FindAllDuplicatesInArray {

    /**
     * without using extra space | Two pointer approach
     * N.B: the items must but in between [1..n] where n is the size of array;
     * mark the corresponding items according to their position,
     * marking the items as (-ve) so we can determine which elements are seen already;
     * if we find another position value -ve
     * means we have already seen it and the position is a duplicate number in the array
     */
    public static List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length < 2)
            return new ArrayList<>();

        List<Integer> duplicates = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int seenIndex = Math.abs(nums[i]) - 1;
            if(nums[seenIndex] < 0)
                duplicates.add(Math.abs(nums[i]));
            else
                nums[seenIndex] *= - 1;
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
//        int[] nums = new int[]{1};
        List<Integer> duplicates = findDuplicates(nums);
        duplicates.forEach(System.out::println);
    }
}
