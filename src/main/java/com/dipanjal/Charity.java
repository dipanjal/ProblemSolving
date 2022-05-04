package com.dipanjal;

public class Charity {

    public static int calc(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += (i*i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calc(2));
    }
}
