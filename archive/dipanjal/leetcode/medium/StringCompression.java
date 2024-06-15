package com.dipanjal.leetcode.medium;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/string-compression/
 * medium
 */
public class StringCompression {

    private static void concat(StringBuilder sb, Character ch, Integer count){
        sb.append(ch);
        if(count > 1)
            sb.append(count);
    }

    public static int compress(char[] chars) {
        if(chars == null)
            return 0;
        if(chars.length < 2)
            return chars.length;

        StringBuilder sb = new StringBuilder(chars.length);

        int start = 0;
        for(int run = 1; run<chars.length; run++) {
            if(chars[start] != chars[run]) {
                int count = run - start;
                concat(sb, chars[start], count);
                start = run;
            }

            if(run == chars.length - 1) {
                int count = (run - start) + 1;
                concat(sb, chars[start], count);
            }
        }

        for(int i=0; i<sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }

    /**
     * Without using extra space
     * TC: O(n)
     */
    public static int compress2(char[] chars) {
        int index = 0;
        int slow = 0;
        while(slow < chars.length) {
            int fast = slow;

            while(fast < chars.length && chars[slow] == chars[fast])
                fast++;

            chars[index++] = chars[slow];
            int count = (fast - slow);
            if(count > 1) {
                for(char c : (count+"").toCharArray()){
                    chars[index++] = c;
                }
            }
            slow = fast;
        }

        return index;
    }

    public static void main(String[] args) {
//        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//        char[] chars = new char[]{'a'};
        int length = compress2(chars);
        for(int i=0; i<length; i++) {
            System.out.print(chars[i]);
        }
//        System.out.println(length);
    }
}
