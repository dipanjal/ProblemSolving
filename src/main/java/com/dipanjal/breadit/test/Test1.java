package com.dipanjal.breadit.test;

/**
 * @author dipanjal
 * @since 6/2/2021
 */

public class Test1 {
    public static double process(int amount, int point) {
        return point == 0 ? amount : amount / Math.pow(10, point);
    }


    public static void main(String[] args) {
        System.out.println(process(12345, 0));
        System.out.println(process(12345, 2));
        System.out.println(process(12345, 5));
        System.out.println(process(12345, 7));
    }
}
