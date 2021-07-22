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

        int start = 0, max = 0;
        Set<Character> seen = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            while(seen.contains(c)){
                seen.remove(s.charAt(start++));
            }
            seen.add(c);
            max = Math.max(max, (i - start) + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
