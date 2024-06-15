package com.dipanjal.leetcode.medium.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dipanjal
 * @since 0.0.1
 */

/*
    3. Longest Substring Without Repeating Characters
    URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Difficulty: Medium
 */

public class LongestSubstring2 {

    /** Sliding Window Algorithm */
    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.isEmpty()) return 0;

        int slow = 0, max = 0;
        Set<Character> seen = new HashSet<>();
        for(int fast=0; fast<s.length(); fast++){
            char c = s.charAt(fast);

            /* While the Set Contains the currently pointed Element */
            while(seen.contains(c)){
                /** Remove Elements from the Hashset */
                seen.remove(s.charAt(slow++));
            }
            seen.add(c);
            int winLength = (fast - slow) + 1; //The New Windows Length
            max = Math.max(max, winLength); //Comparing the Max Length with the New Length
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring(""));
    }
}
