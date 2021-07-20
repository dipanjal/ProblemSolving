package com.dipanjal.wunderman.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * @author dipanjal
 * @since 5/29/2021
 */

public class Test5 {

    public static String[] sortStringDesc(String inputString) {
        String[] strs = inputString.split("");
        Arrays.sort(strs, (s1, s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));
        return strs;
    }

    public static int slotWheels(List<String> history) {
        // Write your code here
        int[] flags = new int[history.get(0).length()];
        for(int i=0; i< history.size(); i++){
            String[] strs = sortStringDesc(history.get(i));
            for(int j=0; j<strs.length; j++){
                if(flags[j] < Integer.parseInt(strs[j])){
                    flags[j] = Integer.parseInt(strs[j]);
                }
            }
        }
        int res = 0;
        for(int i=0; i<flags.length; i++){
            res += flags[i];
        }
        return res;
    }

    public static void main(String[] args) {
//        sortString("137");
        System.out.println(slotWheels(List.of("137", "364", "115", "724")));
        System.out.println(slotWheels(List.of("712", "246", "365", "312")));
    }
}
