package com.dipanjal.aws.real;

import java.util.List;

public class Test1 {

    public static int maximumUserTraffic(List<Integer> login, List<Integer> logout) {
        // Write your code here
        int[] cArr = new int[100000 + 5];
        int logoutMax = 0;
        for(int i=0; i<login.size(); i++) {
            cArr[login.get(i)] += 1 ;
            cArr[logout.get(i)+1] -= 1;

            logoutMax = Math.max(logoutMax, logout.get(i));
        }

        int max = 0;
        for(int i=1; i<=logoutMax; i++){
            cArr[i] += cArr[i-1];
            max = Math.max(max, cArr[i]);
        }

        int count = 0;
        for(int i=1; i<=logoutMax; i++) {
            if(max == cArr[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                maximumUserTraffic(
                        List.of(1, 5, 5),
                        List.of(5, 10, 5)
                )
        );
    }
}
