package com.dipanjal.breadit;

/**
 * @author dipanjal
 * @since 5/25/2021
 */

public class EvenNumPrint {
    private int cnt = 0;
    private int max = 5;

    private int[] ints = { 1, 2, 3, 4, 5, 8, 7, 11, 16, 19, 22 };

    private boolean isEven(int num) {
        cnt++;
        return num % 2 == 0 ? true : false;
    }

    public static void main(String[] args) {
        EvenNumPrint run = new EvenNumPrint();
        for (int cnt = 0; cnt < run.ints.length; cnt++) {
            if (run.ints[cnt] < run.max | run.isEven(run.ints[cnt])) {
                System.out.println(">> value is " + run.ints[cnt]);
            }
        }
        System.out.println("Total is " + run.cnt);
    }

}
