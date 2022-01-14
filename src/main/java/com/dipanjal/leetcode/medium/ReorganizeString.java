package com.dipanjal.leetcode.medium;

import java.util.*;

/**
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/
 * Medium
 */
public class ReorganizeString {

    public static String reorganizeString(String s) {
        /* assume the input is aba */

        /* 1. taking a letter frequency counter map
         * result: a -> 2 , b -> 1
         */
        Map<Character, Integer> countMap = new HashMap<>();
        for(Character ch : s.toCharArray())
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1 );

        /* taking a max heap using priority queue, so the highest frequent letter will be on the top */
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> countMap.get(b) - countMap.get(a) //the sorting comparator, descending order
        );
        maxHeap.addAll(countMap.keySet());

        StringBuilder resBuilder = new StringBuilder();
        while (maxHeap.size() > 1) {
            char maxChar = maxHeap.poll(); //popping out the highest one
            char secMaxChar = maxHeap.poll(); //popping out the 2nd highest one

            resBuilder.append(maxChar).append(secMaxChar); //concat the letters
            countMap.put(maxChar, countMap.get(maxChar) - 1); //decrease frequency count for the highest one
            countMap.put(secMaxChar, countMap.get(secMaxChar) - 1); //decrease frequency count for the 2nd highest one

            //if the letter still has some frequency, again add them into the max heap.
            if(countMap.get(maxChar) > 0) maxHeap.add(maxChar);
            if(countMap.get(secMaxChar) > 0) maxHeap.add(secMaxChar);
        }

        /* Collecting the Leftovers */
        if(!maxHeap.isEmpty()) {
            char lastChar = maxHeap.poll();

            /* if last char has more than one occurrence,
            that means we can not split them, so return empty  */
            if(countMap.get(lastChar) > 1)
                return "";
            else
                resBuilder.append(lastChar);
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aabc"));
        System.out.println(reorganizeString("aaac"));
        System.out.println(reorganizeString("aaabc"));
    }
}
