package com.dipanjal.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllDisappearedNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length < 2)
            return null;

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums ) numSet.add(num);
        for(int i = 1 ; i <= nums.length; i++){
            if(!numSet.contains(i))
                missingNumbers.add(i);
        }
        return missingNumbers;
    }

    /**
     * without using extra space
     * N.B: the items must but in between [1..n] where n is the size of array;
     * mark the corresponding items according to their position,
     * marking the items as (-ve) so we can determine which elements are not marked;
     * example: a[0] = 5, go to index (5-1) goto => index 4 and make the arr[4] -ve
     * now traverse the array one more time and find the unmarked value indices;
     * missingNum = if arr[i] = +ve -> i+1 will be the missing number
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        if(nums == null || nums.length < 2)
            return null;

        List<Integer> missingNumbers = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int seenIndex = Math.abs(nums[i]) - 1;
            if(nums[seenIndex] > 0)
                nums[seenIndex] *= -1;
            else
                duplicates.add(Math.abs(nums[i]));
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0)
                missingNumbers.add(i+1);
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        FindAllDisappearedNumbersInArray obj = new FindAllDisappearedNumbersInArray();
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> missingNums = obj.findDisappearedNumbers2(arr);
        missingNums.forEach(System.out::println);
    }
}
