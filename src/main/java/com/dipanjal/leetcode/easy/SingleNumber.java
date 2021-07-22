package com.dipanjal.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dipanjal
 * @since 0.0.1
 */

/*
136. Single Number
https://leetcode.com/problems/single-number/
Difficulty: Easy
 */

public class SingleNumber {

    /**
     * Bit Manipulation
     * reference video: https://www.youtube.com/watch?v=eXl0HBm2RrA
     *
     */

    public static int singleNumber(int[] nums) {
        int unique = 0;
        for(int i=0; i<nums.length; i++)
            unique ^= nums[i];
        return unique;
    }

    public static void main(String[] args) {
//        System.out.println(singleNumber(new int[]{3,0,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }


}
