package com.dipanjal.problem.solving.strings;

import com.sun.source.tree.BreakTree;

/**
 * @author dipanjal
 * @since 5/1/2021
 */

public class StringConstruction {

    private static int getMinimumCost(String s){
        final int NUMBER_OF_LETTERS = 26;
        int[] charCount = new int[NUMBER_OF_LETTERS];
        int offset = 'a';
        int cost = 0;
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - offset;
            if(charCount[index] == 0){
                charCount[index]++;
                cost++;
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumCost("abcd"));
        System.out.println(getMinimumCost("abab"));
        System.out.println(getMinimumCost("abbcca"));

        int x = 5;
        Double x2 = Double.valueOf(x);
    }
}
