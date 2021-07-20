package com.dipanjal.problem.solving.strings;

import java.util.stream.Stream;

/**
 * @author dipanjal
 * @since 4/30/2021
 */

public class MakAnagram {

    private static final int NUMBER_LETTERS = 26;

    private static int[] getCharCount(String s){
        int[] charCount = new int[NUMBER_LETTERS];
        int offset = 'a';
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - offset;
            charCount[index]++;
        }
        return charCount;
    }


    private static boolean isNotPresent(char ch, int[] arr){
        int index = ch - 'a';
        return arr[index] == 0;
    }

    private static void remove(char ch, int[] arr){
        int index = ch - 'a';
        arr[index]--;
    }

    /** need to count how many letters need to changed */
    private static int anagramHackerRank(String str) {
        if(str.length() % 2 == 1)
            return -1;
        String str1 = str.substring(0, str.length() / 2);
        String str2 = str.substring(str.length() / 2);

        int[] charCount2 = getCharCount(str2);

        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(isNotPresent(str1.charAt(i), charCount2))
                count++;
            else
                remove(str1.charAt(i), charCount2);
        }
        return count;
    }

    private static int getDelta(int[] arr1, int[] arr2) {
        if(arr1.length!=arr2.length) return  -1;
        int delta = 0;
        for(int i=0; i<arr1.length; i++) {
            int difference = Math.abs(arr1[i] - arr2[i]);
            delta += difference;
        }
        return delta;
    }
    private static int makingAnagram(String s1, String s2){
        int[] charCount1 = getCharCount(s1);
        int[] charCount2 = getCharCount(s2);
        return getDelta(charCount1, charCount2);
    }




    public static void main(String[] args) {

        /*String [] inputs = {
                "aaabbb",
                "ab",
                "abc",
                "mnop",
                "xyyx",
                "xaxbbbxx",
                "asdfjoieufoa",
                "fdhlvosfpafhalll",
                "mvdalvkiopaufl",
        };
        Stream.of(inputs)
                .forEach(str -> System.out.println(str + ": "+ anagramHackerRank(str)));*/
//        System.out.println(anagramHackerRank("fdhlvosfpafhalll"));
        System.out.println(makingAnagram("cde", "abc"));
        System.out.println(makingAnagram("absdjkvuahdakejfnfauhdsaavasdlkj", "djfladfhiawasdkjvalskufhafablsdkashlahdfa"));
    }
}
