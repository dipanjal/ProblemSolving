package com.dipanjal.leetcode.twosum;

import java.util.*;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int difference = target - nums[i];
            if(map.containsKey(difference))
                return new int[] { i, map.get(difference) };
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {2,11,7,15};
        int target = 9;
        int[] res = new TwoSum().twoSum(arr, target);
        Arrays.stream(res).forEach(System.out::println);
    }
}
