package com.dipanjal.problem.solving.strings;

/**
 * @author dipanjal
 * @since 5/1/2021
 */

public class GameOfThrones {

    private static int[] getCharCount(String s){
        final int NUMBER_OF_LETTERS = 26;
        int[] charCount = new int[NUMBER_OF_LETTERS];
        int offset = 'a';
        for(int i=0; i<s.length(); i++)
            charCount[(s.charAt(i) - offset)]++;
        return charCount;
    }

    private static int getTotalOddCounts(int[] countArr){
        int odd = 0;
        for(int count : countArr){
            if(count % 2 != 0)
                odd++;
        }
        return odd;
    }

    public static String gameOfThrones(String s) {
        int[] charCount = getCharCount(s);
        int totalOddCounts = getTotalOddCounts(charCount);
        return totalOddCounts > 1 ? "NO" : "YES";
    }

    public static void main(String[] args) {
        System.out.println(gameOfThrones("aaabbbb"));
        System.out.println(gameOfThrones("cdefghmnopqrstuvw"));
    }
}
