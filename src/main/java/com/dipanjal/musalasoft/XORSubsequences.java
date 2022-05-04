package com.dipanjal.musalasoft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dipanjal
 * @since 5/15/2021
 */

public class XORSubsequences {
    private static int TOW_POW_16 = 65536;

    public static void main(String[] args) {
//        System.out.println(checkSubsequence(null));
//        int[] arr = {2, 1, 3, 5, 2};
//        System.out.println(subsetXOR(0, arr));
        System.out.println(subsetXOR(5, List.of(1, 2, 2, 1, 3)));
//        System.out.println(subsetXOR(0, List.of(1, 2, 2, 1, 3)));
    }

    static int subsetXOR(int k, List<Integer> arr) {

        int n = arr.size();

        int dp[][] = new int[k][n], sum = 0;

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int l = 1; l < k; l++) {
            for (int i = l; i < n; i++) {
                dp[l][i] = 0;
                for (int j = l - 1; j < i; j++) {
                    if (arr.get(j) < arr.get(i)) {
                        dp[l][i] += dp[l - 1][j];
                    }
                }
            }
        }

        for (int i = k - 1; i < n; i++) {
            sum += dp[k - 1][i];
        }
        return sum;
    }

    private static int[] createXVector(int[] arrXor) {
        int[] xVector = new int[TOW_POW_16];
        for (int i = 0; i < arrXor.length; i++) {
            xVector[arrXor[i]]++;
        }
        return xVector;
    }

    private static String checkSubsequence(int[] arrXor) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arrXor.length; i++) {
            addToMap(map, arrXor[i]);
            for (int j = i + 1; j < arrXor.length; j++) {
                addToMap(map, arrXor[i] ^ arrXor[j]);
            }
        }
        int maxKey = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) > maxVal) {
                maxVal = map.get(key);
                maxKey = key;
            } else if (map.get(key) == maxVal && key < maxKey) {
                maxKey = key;
            }
        }
        return maxKey + " " + maxVal;

    }

    private static void addToMap(Map<Integer, Integer> map, int el) {
        if (map.containsKey(el)) {
            map.put(el, map.get(el) + 1);
        } else {
            map.put(el, 1);
        }
    }
}
