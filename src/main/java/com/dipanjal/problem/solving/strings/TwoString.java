package com.dipanjal.problem.solving.strings;

/**
 * @author dipanjal
 * @since 5/1/2021
 */

public class TwoString {

    private static int[] getCharCount(String s){
        final int NUMBER_OF_LETTERS = 26;
        int[] charCount = new int[NUMBER_OF_LETTERS];
        int offset = 'a';
        for(int i=0; i<s.length(); i++)
            charCount[(s.charAt(i) - offset)]++;
        return charCount;
    }

    private static boolean hasCommonSubString(int[] countArr, String anotherString){
        for(int i=0; i<anotherString.length(); i++){
            int index = anotherString.charAt(i) - 'a';
            int count = countArr[index];
            if(count > 0)
                return true;
        }
        return false;
    }

    public static String twoStrings(String s1, String s2) {
        int[] charCount1 = getCharCount(s1);
        return hasCommonSubString(charCount1, s2) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}
