package com.dipanjal.wunderman;

/**
 * @author dipanjal
 * @since 5/26/2021
 */

public class Test {

    private static int LINE_NO;

    static {
        LINE_NO = 0;
        System.out.println(++LINE_NO+": Static Block");
    }

    {
        System.out.println(++LINE_NO+": Instance Block");
    }

    public Test() {
        System.out.println(++LINE_NO+": Constructor");
    }

    public void method(){
        System.out.println(++LINE_NO+": Method");
    }

    public static void main(String[] args) {
        new Test().method();
    }
}
