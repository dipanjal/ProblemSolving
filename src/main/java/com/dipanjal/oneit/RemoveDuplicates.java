package com.dipanjal.oneit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dipanjal
 * @since 5/21/2021
 */

public class RemoveDuplicates {

    private static char[] getAsCharArray(Set<Character> characterSet){
        char [] chars = new char[characterSet.size()];
        int i = 0;
        for(Character c : characterSet){
            chars[i++] = c;
        }
        return chars;
    }

    public static char[] removeDuplicates (char[] arg) {
        Set<Character> characters = new HashSet<>();
        for(char c : arg)
            characters.add(c);
        return getAsCharArray(characters);
    }

    public static void main(String[] args) {
        char[] uniqueChars = removeDuplicates(new char[]{'a','b','b','c','a','a','d'});
        Collections.singletonList(uniqueChars)
                .forEach(System.out::println);
    }
}
