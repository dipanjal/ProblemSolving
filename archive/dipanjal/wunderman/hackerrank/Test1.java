package com.dipanjal.wunderman.hackerrank;

/**
 * @author dipanjal
 * @since 5/29/2021
 */

public class Test1 {

    public static int isPrime(long n) {
        // Write your code here
        if (n < 2) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n % 2 == 0) {
            return 2;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(37961921));
    }
}
