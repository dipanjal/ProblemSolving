package com.dipanjal;

import java.util.Map;
import java.util.TreeMap;

public class FreqCounter {
    static int x = 5;
    static int y;

    static void test(int cx){
        System.out.println(y);
    }

    static {
        System.out.println(x);
        y = x*6;
    }

    public static String frequency(String input1){
        Map<Character, Integer> count = new TreeMap<>();
        for(int i=0; i<input1.length(); i++) {
            char ch = input1.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        count.forEach((key, value) -> sb.append(key).append(value));
        return sb.toString();
    }


    public static void main(String[] args) {
//        System.out.println(frequency("babdc"));
        int i = 2;
        int x[] = {10,20,50,45,95,14};
        x[i] = x[i=i++];
        System.out.println(x[i]);
    }
}
