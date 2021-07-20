package com.dipanjal.wunderman.hackerrank;

/**
 * @author dipanjal
 * @since 5/29/2021
 */

public class Test2 {

    public static long pthFactor(long n, long p) {
        // Write your code here
        long begin  = 1;
        long end =  findMaxNoOfDivisor(n);

        if(p > end) return 0;

        for(int i=1; i*i<=n; i++){
            if(i*i==n){
                if(p == begin){
                    return i;
                }
            }
            else if(n%i==0){
                if(p == begin){
                    return i;
                }if (p == end){
                    return n/i;
                }
                begin++;
                end--;
            }
        }
        return 0;
    }

    public static long findMaxNoOfDivisor(long n){
        int divisor = 0;
        for(int i=1; i*i<=n; i++){
            if(i*i==n)
                divisor++;
            else if(n%i==0)
                divisor+=2;
        }
        return divisor;
    }

    public static void main(String[] args) {
        System.out.println(pthFactor(10, 3));
//        System.out.println(pthFactor(22876792454961, 28));
    }
}
