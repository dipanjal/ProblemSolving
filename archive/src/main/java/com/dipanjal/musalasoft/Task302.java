package com.dipanjal.musalasoft;

import java.util.*;

/**
 * @author dipanjal
 * @since 5/15/2021
 */

public class Task302 {

    private static boolean isAnagram(String str1, String str2){
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

    private static Map<String, Integer> getAnagramMap(List<String> wordSet){
        Map<String, Integer> anagramMap = new HashMap<>();
        for(int i = 0; i < wordSet.size(); i++){
            for(int j = i+1; j < wordSet.size(); j++){
                if (isAnagram(wordSet.get(i), wordSet.get(j))) {
                    System.out.println(wordSet.get(i) +
                            " is anagram of " + wordSet.get(j));
                    Integer count = anagramMap.getOrDefault(wordSet.get(i), 0) + 1;
                    anagramMap.put(wordSet.get(i), count);
                    anagramMap.put(wordSet.get(j), count);
                }
            }
        }
        return anagramMap;
    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences){
        Map<String, Integer> anagramMap = getAnagramMap(wordSet);
        List<Long> counts = new ArrayList<>();
        for(String s : sentences){
            int count = 0;
            for(String word : s.split(" ")){
                if(anagramMap.containsKey(word)){
                    count += (anagramMap.get(word) + 1);
                }

            }
            counts.add((long) count);
        }
        return counts;
    }

    public static void main(String[] args) {
        List<String> words = List.of("the", "bats", "tabs", "in", "cat", "act");
        List<String> sentences = List.of("cat the bats", "in the act", "act tabs in");
        countSentences(words, sentences);
    }
}
