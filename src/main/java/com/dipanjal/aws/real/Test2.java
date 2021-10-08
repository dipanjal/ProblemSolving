package com.dipanjal.aws.real;

import java.util.Arrays;

public class Test2 {

    public static long findPasswordStrength(String password) {
        /*int[] track = new int[password.length()+1];
        int[] charArr = new int[40];
        int count;
        for(int i = 0; i<password.length(); i++) {
            charArr[password.charAt(i) - 'a']++;
            count = 0;
            for (int j = 0; j < 26; j++) {
                if (charArr[j] >= 1)
                    count++;
            }
            track[i] = count;

*//*            if(i > 0)
                track[i]+=track[i -1];*//*
        }

        int p2 = 0, res = 0;
        for(int i=0; i<password.length(); i++){
            p2 = i;
            while (p2 < password.length()){
                if(i == 0){
                    res += track[p2];
                }else{
                    res += track[p2] - track[i-1];
                }
                p2++;
            }
        }

        return res;*/



        // Write your code here
        int SIZE = 128;
        int[][] index = new int[128][2];
        for(int i=0; i<SIZE; i++)
            Arrays.fill(index[i], -1);

        int res = 0;
        for(int i=0; i<password.length(); i++){
            int c = password.charAt(i) - 'a';
            res = res + (password.length()-index[c][1]) * (index[c][1] - index[c][0]);
            index[c] = new int[]{index[c][1], i};
        }

        for(int c=0; c<SIZE; c++)
            res = res + ((password.length()-index[c][1]) * (index[c][1] - index[c][0]));

        return res;

        /*List<Integer>[] record = new List[128];
        int M = 1000000007;
        int n = password.length();
        for (int i = 0; i < 128; i++) {
            record[i] = new ArrayList<>();
        }
        for (int i = 0; i < password.length(); i++) {
            record[password.charAt(i)].add(i);
        }
        long result = 0;
        for (int i = 0; i < 128; i++) {
            int size = record[i].size();
            for (int j = 0; j < size; j++) {
                int index = record[i].get(j);
                int left = j == 0 ? -1 : record[i].get(j - 1);
                int right = j == size - 1 ? n : record[i].get(j + 1);
                result += (index - left) * (right - index);
//                result %= M;
            }
        }
        return (int)result;*/

        /*char[] s = password.toCharArray();
        long res = 0;

        for (int n = password.length(), i = 0, l = 0, r = 0; i < n; i++) {
            for (l = i - 1; l >= 0 && s[l] != s[i]; l--);
            for (r = i + 1; r < n && s[r] != s[i]; r++);
            res += (r - i) * (i - l);
        }
        return res;*/
    }

    public static void main(String[] args) {
        System.out.println(
                findPasswordStrength("good")
        );
    }
}
