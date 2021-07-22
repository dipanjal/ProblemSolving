package com.dipanjal.leetcode.easy.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dipanjal
 * @since 0.0.1
 * problem url: https://leetcode.com/problems/contains-duplicate/
 */

public class ContainsDuplicate {

    /** By Set **/
    /* 4 ms */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for(int n : nums){
            if(!uniques.add(n))
                return true;
        }
        return false;
    }

    /** By Sorting **/
    /* 8 ms */
    public static boolean containsDuplicate2(int[] nums) {
        /*
            is the array sorting killing the time ?
            Though Arrays.sort() use merge sort in the background
            Time Complexity: O(nLog(n))
         */
        Arrays.sort(nums);
        for(int i=0; i<(nums.length - 1); i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        System.out.println(containsDuplicate2(nums1));
        int[] nums2 = {1,2,3,4};
        System.out.println(containsDuplicate2(nums2));
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate2(nums3));
    }
}
