package com.dipanjal.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

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
                /** SWAP ;) */
                int temp = nums[zeroIndex];
                nums[zeroIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,3,12};
        moveZeroes(nums);
        System.out.println(
                Arrays.stream(nums)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", "))
        );

    }
}
