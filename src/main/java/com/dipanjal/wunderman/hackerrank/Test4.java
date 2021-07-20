package com.dipanjal.wunderman.hackerrank;

import java.util.*;

/**
 * @author dipanjal
 * @since 5/29/2021
 */

public class Test4 {

    private static class Pair {
        public String key;
        public Integer count;

        public Pair(String key, Integer count) {
            this.key = key;
            this.count = count;
        }
    }

    public static List<String> groupTransactions(List<String> transactions) {
        // Write your code here
        Map<String, Integer> data = new HashMap<>();
        for(String s : transactions){
            data.put(s.toLowerCase(), data.getOrDefault(s.toLowerCase(), 0)+1);
        }

        List<Pair> pairs = new ArrayList<>();
        data.forEach((k, v) -> pairs.add(new Pair(k, v)));

        pairs.sort((p1, p2) -> {
            if (p2.count > p1.count)
                return 1;
            else{
                return p1.count > p2.count ? 1 : p1.key.compareTo(p2.key);
            }

        });
        List<String> historyCount = new ArrayList<>();
        for(Pair p : pairs){
            historyCount.add(p.key + " " + p.count);
        }
        return historyCount;
    }

    public static void main(String[] args){
        groupTransactions(List.of("notebook", "notebook", "mouse", "keyboard", "mouse"))
                .forEach(System.out::println);
    }
}
