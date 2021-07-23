package com.dipanjal.leetcode;

import java.util.Arrays;

/**
 * @author dipanjal
 * @since 0.0.1
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 * Difficulty : Easy
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[zeroIndex];
                nums[zeroIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }
}
