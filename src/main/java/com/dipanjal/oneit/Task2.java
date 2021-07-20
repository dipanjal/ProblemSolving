package com.dipanjal.oneit;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dipanjal
 * @since 5/21/2021
 */

public class Task2 {

    public static String countWordOccurrences (String text) {
        // return "dog,1\ncat,2";
        text = text.toLowerCase();
        Map<String, Integer> occMap = new HashMap<>();
        String[] parts = text.split("[\\s\\.,]");
        for(String part : parts){
            if(part.length() > 0){
                occMap.put(part, occMap.getOrDefault(part, 0) + 1);
            }
        }

        AtomicReference<String> atomic = new AtomicReference<>("");
        occMap.forEach((s, integer) -> {
            String line = s+","+integer+"\n";
            atomic.set(atomic.get().concat(line));
        });

        return atomic.get();
    }

    public static int addSubtractPairwise (int[] arg) {
        int res = 0;
        int lastMaxIndex = 0;
        for(int i=0; i< arg.length ;i++){
            if(i == 0){
                lastMaxIndex = i + 1;
                int val2 = lastMaxIndex == arg.length ? 1 : arg[lastMaxIndex++];
                res = arg[0] * val2;
            }
            if(i%2 != 0){
                //odd
                int val1 = lastMaxIndex == arg.length ? 1 : arg[lastMaxIndex++];
                int val2 = lastMaxIndex == arg.length ? 1 : arg[lastMaxIndex++];
                res = res - (val1 * val2);
            }else{
                int val1 = lastMaxIndex == arg.length ? 1 : arg[lastMaxIndex++];
                int val2 = lastMaxIndex == arg.length ? 1 : arg[lastMaxIndex++];
                res = res + (val1 * val2);
            }
        }
        return  res;
    }


    public static int binarySearch(ArrayList<Integer> arr, int item)
    {
        int left = 0, right = arr.size() - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // Check if item is present at mid
            if (arr.get(mid) == item)
                return mid;

            // If item greater, ignore left half
            if (arr.get(mid) < item)
                left = mid + 1;

                // If item is smaller, ignore right half
            else
                right = mid - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(countWordOccurrences("a dog on a cat. a dog and cat and a cat."));

//        System.out.println(addSubtractPairwise(new int[]{1,2,3}));

    }
}
