package com.dipanjal.problem.solving.strings;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author dipanjal
 * @since 4/30/2021
 */

public class Anagram {

    private static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        if(!str1.matches("^[a-z]$") || !str2.matches("^[a-z]$")){
            System.out.println("Invalid Charset");
            return false;
        }

        Map<Character, Integer> inputCountMap = new HashMap<>();
        Map<Character, Integer> input2CountMap = new HashMap<>();
        for(int i=0; i<str1.length(); i++){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            int input1CharCount = inputCountMap.getOrDefault(char1, 0) + 1;
            int input2CharCount = input2CountMap.getOrDefault(char2, 0) + 1;
            inputCountMap.put(char1, input1CharCount);
            input2CountMap.put(char2, input2CharCount);
        }

        for(Map.Entry<Character, Integer> charMap : inputCountMap.entrySet()){
            int count2 = input2CountMap.getOrDefault(charMap.getKey(), 0);
            if(charMap.getValue() != count2)
                return false;
        }
        return true;
    }

    private static boolean isAnagram2(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int[] countArr1 = new int['z'+1];
        int[] countArr2 = new int['z'+1];
        for(int i=0; i<str1.length(); i++){
            countArr1[str1.charAt(i)]++;
            countArr2[str2.charAt(i)]++;
        }

        for(int i=0; i<str1.length(); i++) {
            if(countArr1[str1.charAt(i)] != countArr2[str1.charAt(i)])
                return false;
        }
        return true;
    }





    public static void main(String[] args) {
        String result = isAnagram("abcde", "xyzwf") ? "Anagram" : "Not Anagram";
        String result2 = isAnagram2("abcde", "xyzwf") ? "Anagram" : "Not Anagram";
        System.out.println(result);
        System.out.println(result2);
    }
}
