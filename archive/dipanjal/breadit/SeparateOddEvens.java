package com.dipanjal.breadit;

/**
 * @author dipanjal
 * @since 5/26/2021
 */

public class SeparateOddEvens {

    public static void main(String[] args) {
        int[] arr = new int[]{12, 17, 70, 15, 22, 65, 21, 90};
        int[] odds = new int[arr.length];
        int[] evens = new int[arr.length];
        int i=0, m=0, n=0;
        while(i<arr.length){
            if(arr[i] % 2 == 0){
                evens[m++] = arr[i++];
            }else{
                odds[n++] = arr[i++];
            }
        }
        for(i=0; i<m+1; i++){
            arr[i] = evens[i];
        }
        for(i=0; i<n+1; i++){
            int offset = i + m;
            if(offset < arr.length)
                arr[offset] = odds[i];
        }
        for (i=0; i<arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println("");
    }
}
