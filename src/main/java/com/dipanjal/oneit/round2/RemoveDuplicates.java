package com.dipanjal.oneit.round2;

import java.util.*;

/**
 * @author dipanjal
 * @since 5/21/2021
 */

public class RemoveDuplicates {

    private static char[] getAsCharArray(List<Character> characterSet){
        char [] chars = new char[characterSet.size()];
        int i = 0;
        for(Character c : characterSet){
            chars[i++] = c;
        }
        return chars;
    }

    public static char[] removeDuplicates (char[] arg) {
        //Set<Character> characters = new HashSet<>();
        //'a','b','b','c','a','a','d'
        List<Character> charList = new ArrayList<>();
        int[] trace = new int[100];
        for(int i = arg.length - 1; i >= 0; i--) {
            int index = arg[i] - 97;
            if(trace[index] == 0) {
                trace[index] = 1;
                charList.add(arg[i]);
            }
        }
        Collections.reverse(charList);
        return getAsCharArray(charList);
    }

    public static void main(String[] args) {
        char[] uniqueChars = removeDuplicates(new char[]{'a','b','b','c','a','a','d'});
        Collections.singletonList(uniqueChars)
                .forEach(System.out::println);
    }
}
