package com.dipanjal.problem.solving.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dipanjal
 * @since 5/1/2021
 */

public class SharlockValidString {

    private static Map<Character, Integer> getCharCountMap(String s){
        Map<Character, Integer> frequencies = new HashMap<>();
        for(char letter : s.toCharArray()) {
            int count = frequencies.getOrDefault(letter, 0) + 1;
            frequencies.put(letter, count);
        }
        return frequencies;
    }

    public static String sharlock2(String s1) {
        Map<Character, Integer> charCountMap = getCharCountMap(s1);
        Set<Integer> uniqueCountSet = new HashSet<>(charCountMap.values());

        if(uniqueCountSet.size() > 2)
            return "NO";
        if(uniqueCountSet.size() == 1)
            return "YES";
        return "";

        /*int maxFrequency = Collections.max(charCountMap.values());
        int minFrequency = Collections.min(charCountMap.values());
        if(minFrequency == maxFrequency)
            return "YES";*/

        /*int minCount = 0, maxCount = 0;
        for(Long count : charCountMap.values()){
            if(count.equals(maxFrequency))
                maxCount ++;
            else if (count.equals(minFrequency))
                minCount ++;
        }
        if(minCount == 1 || (maxCount == 1 && maxFrequency==minFrequency+1))
            return "YES";
        return "NO";*/
    }

    public static void main(String[] args) {
        System.out.println(sharlock2("aabbccddd"));
    }
}
