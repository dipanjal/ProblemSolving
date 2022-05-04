package com.dipanjal.leetcode.easy.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dipanjal
 * @since 0.0.1
 * Same as previous Two Sum problem we have solved,
 * but now the given array is sorted, need to find twoSum
 * target: TC O(n), SC: O(1)
 */


public class TweSumSorted {

    public static int[] twoSum(int[] nums, int target) {
        /*Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int difference = target - nums[i];
            if(map.containsKey(difference))
                return new int[] { i, map.get(difference) };
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};*/

        int start = 0;
        int end = nums.length - 1;
        while(start<=end){

            int twoSum = nums[start] + nums[end];
            if(twoSum == target)
                return new int[] {start, end};
            else if (twoSum > target)
                end --;
            else
                start ++;
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(arr, target);
        Arrays.stream(res).forEach(System.out::println);
    }
}
