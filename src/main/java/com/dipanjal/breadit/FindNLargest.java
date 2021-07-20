package com.dipanjal.breadit;

/**
 * @author dipanjal
 * @since 5/25/2021
 */

public class FindNLargest {
    private enum Sorting {
        ASC,
        DESC
    };

    public static void merge(
            int[] a,
            int[] leftArr,
            int[] rightArr,
            Sorting sorting) {

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

    public static void mergeSort(int[] arr, int length, Sorting sorting) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            rightArr[i - mid] = arr[i];
        }
        mergeSort(leftArr, mid, sorting);
        mergeSort(rightArr, length - mid, sorting);
        merge(arr, leftArr, rightArr, sorting);
    }

    private static int[] removeDuplicates(int[] arr) {
        if(arr.length == 0 || arr.length == 1)
            return arr;

        int[] uniques = new int[arr.length];
        for(int i=0, j=0; i<arr.length; i++){
            if(i == arr.length - 1)
                uniques[j++] = arr[i];
            else if(arr[i] != arr[i+1])
                uniques[j++] = arr[i];
        }
        return uniques;
    }

    private static int getNthLargest(int[] arr, int nth){
        mergeSort(arr, arr.length, Sorting.DESC);
        int[] uniques = removeDuplicates(arr);
        if(nth > arr.length)
            return -1;
        return uniques[nth - 1];
    }

    public static void main(String[] args) {
        int[] arr={7,5,6,1,6,4,2};
        int nthLargest = getNthLargest(arr, 3);
        System.out.println(nthLargest);
    }
}
