package com.dipanjal.ocp.practiece.chapter7;

import java.time.Period;

/**
 * @author dipanjal
 * @since 4/19/2021
 */

public interface TestInterface {
    //can I declare a variable ?
    Period MAX_PERIOD = Period.ofDays(5);
    public static final Period MAX_PERIOD_FINAL = Period.ofDays(5);
    public Period MAX_PERIOD_INS = Period.ofDays(5);

    void testCode();

    default void print(Object obj) {
        System.out.println(obj.toString());
    }

    static void printStatic(String str){
        return;
    }

    void common();

}
