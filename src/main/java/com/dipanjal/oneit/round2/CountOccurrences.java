package com.dipanjal.oneit.round2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class CountOccurrences {
    public static String countWordOccurrences (String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            int count = map.getOrDefault(word, 0);
            map.put(word,  count + 1);
        }

        StringBuilder builder = new StringBuilder();
        map.forEach((key, val) -> builder.append(key+","+val+"\n"));
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "The fox, on the log";
        System.out.println(
                countWordOccurrences(s)
        );
    }
}
