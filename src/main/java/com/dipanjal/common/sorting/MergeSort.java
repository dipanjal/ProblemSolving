package com.dipanjal.common.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author dipanjal
 * @since 0.0.1
 * Time Complexity: O(nLog(n))
 */

public class MergeSort {

    private static int step;
    static {
        step = 0;
    }

    private enum Sorting {
        ASC,
        DESC
    }

    public static void mergeSort(int[] arr, MergeSort.Sorting sorting) {

        /* When the array length in Less than 2,
           we have nothing to split from the array
           So we will return
        */
        if (arr.length < 2) return;

        /* Splitting the Array into two Sub Arrays */
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        for (int i = 0; i < mid; i++)
            leftArr[i] = arr[i];

        for (int i = mid; i < arr.length; i++)
            rightArr[i - mid] = arr[i];

        /* Recursively Splitting these left and right sub arrays
           to more Sub-Arrays until these Arrays reach their atomic level.
           means we will stop splitting and go for merge when the array length = 1
         */
        mergeSort(leftArr, sorting);
        mergeSort(rightArr, sorting);
        merge(arr, leftArr, rightArr, sorting);
    }

    /**
     *
     * @param arr Array of Elements
     * @param leftArr Left Array Divided from arr
     * @param rightArr Right Array Divided from arr
     * @param sorting Sorting Order, Ascending / Descending
     */
    private static void merge(int[] arr, int[] leftArr, int[] rightArr, MergeSort.Sorting sorting) {
        System.out.printf("------- Merge Sequence (%s) ---------%n", ++step);
        print("Array Before Merge", arr);
        print("Left Array", leftArr);
        print("Right Array", rightArr);

        int i = 0, j = 0, k = 0;

        /* Sorting Logic */
        System.out.println("~~~~~~~~~~~~~~ Comparison Start ~~~~~~~~~~~~~");
        while (i < leftArr.length && j < rightArr.length) {
            if(Sorting.ASC == sorting){
                System.out.printf("is LEFT: %s <= RIGHT: %s : %s%n", leftArr[i], rightArr[j], (leftArr[i]<=rightArr[j]));
                arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++]; // When Left[i] is <= Right[j] then Set Arr[k] = Left[i] otherwise Arr[k] = Right[j]
                print("Array Tracing", arr);
            }
            else
                arr[k++] = (leftArr[i] >= rightArr[j]) ? leftArr[i++] : rightArr[j++]; // When Left[i] is >= Right[j] then Set Arr[k] = Left[i] otherwise Arr[k] = Right[j]
        }
        System.out.println("~~~~~~~~~~~ Comparison End ~~~~~~~~~~~");

        print("Before Collecting Leftovers", arr);
        System.out.printf("Array Rewrite Needed %s%n", (arr.length - k));
        System.out.printf("Left Array Leftovers %s%n", (leftArr.length - i));
        System.out.printf("Right Array Leftovers %s%n", (rightArr.length - j));

        /* Collect The Left Overs from Left Array */
        while (i < leftArr.length){
            System.out.printf("Rewriting %s with %s%n", arr[k], leftArr[i]);
            arr[k++] = leftArr[i++];
            print("Array Tracing", arr);
        }

        /* Collect The Left Overs from Right Array */
        while (j < rightArr.length){
            System.out.printf("Rewriting %s with %s%n", arr[k], rightArr[j]);
            arr[k++] = rightArr[j++];
            print("Array Tracing", arr);
        }

        print("Merged Array",  arr);
    }

    public static void print(int[] arr){
        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    public static void print(String message, int[] arr){
        String itemJoined = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(message+": "+itemJoined);
    }

    public static void main(String[] args) {
        int[] arr = {38,27,43,3,9,82,10};
        print("Input Array",arr);
        mergeSort(arr, Sorting.ASC);
        System.out.println("--------------------------------");
        print("Output Array",arr);
    }
}
