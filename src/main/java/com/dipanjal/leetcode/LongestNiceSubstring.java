package com.dipanjal.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dipanjal
 * @since 0.0.1
 */

/*
    1763. Longest Nice Substring
    URL: https://leetcode.com/problems/longest-nice-substring/

Example 1:
    Input: s = "YazaAay"
    Output: "aAa"
    Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
    "aAa" is the longest nice substring.
Example 2:
    Input: s = "c"
    Output: ""
    Explanation: There are no nice substrings.
 */

public class LongestNiceSubstring {

    /** Recursion: Divide and Conquer */
    public static String longestNiceSubstring(String s){
        if(s.length() < 2) return "";

        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) set.add(c);

        for(int i=0; i<s.length(); i++){
            if(set.contains(Character.toUpperCase(s.charAt(i)))
                    && set.contains(Character.toLowerCase(s.charAt(i)))){
                continue;
            }
            String leftSub = longestNiceSubstring(s.substring(0, i));
            String rightSub = longestNiceSubstring(s.substring(i+1));

            return leftSub.length() >= rightSub.length() ? leftSub : rightSub;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring("c"));
        System.out.println(longestNiceSubstring("dDzeE"));
        System.out.println(longestNiceSubstring("AazzBb"));
    }
}
