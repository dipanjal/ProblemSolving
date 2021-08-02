package com.dipanjal.common.searching;

import com.dipanjal.common.sorting.MergeSort;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class BinarySearch {


    private static boolean binarySearch(int[] nums, int val, boolean unsorted) {
        if(unsorted)
            MergeSort.mergeSort(nums, MergeSort.Sorting.ASC);
        return binarySearch(nums, val);
    }

    private static boolean binarySearch(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(val == nums[mid])
                return true;
            else if (val < nums[mid])
                end = mid - 1; //value is less that mid point value; so moving left
            else
                start = mid + 1;//value is grater that mid point value; so moving right
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {7,3,8,1,2,10,0,4};
        System.out.println(binarySearch(nums, 7, true));
    }
}
