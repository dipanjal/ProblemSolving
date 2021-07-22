package com.dipanjal.common.sorting;

import java.util.Arrays;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class MergeSort {

    private enum Sorting {
        ASC,
        DESC
    }

    private static void merge(int[] a, int[] leftArr, int[] rightArr, MergeSort.Sorting sorting) {

        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if(Sorting.ASC == sorting){
                a[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
            } else {
                a[k++] = (leftArr[i] >= rightArr[j]) ? leftArr[i++] : rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            a[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            a[k++] = rightArr[j++];
        }
    }

    public static void mergeSort(int[] arr, int length, MergeSort.Sorting sorting) {
        if (length < 2) return;

        int mid = length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        for (int i = 0; i < mid; i++)
            leftArr[i] = arr[i];

        for (int i = mid; i < length; i++)
            rightArr[i - mid] = arr[i];

        mergeSort(leftArr, mid, sorting);
        mergeSort(rightArr, length - mid, sorting);
        merge(arr, leftArr, rightArr, sorting);
    }

    public static void print(int[] arr){
        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = {38,27,43,3,9,82,10};
        print(arr);
        mergeSort(arr, arr.length, Sorting.ASC);
        System.out.println("--------------------------------");
        print(arr);
    }
}
