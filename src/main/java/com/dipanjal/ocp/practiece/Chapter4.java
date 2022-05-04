package com.dipanjal.ocp.practiece;

import static java.lang.System.out;

/**
 * @author dipanjal
 * @since 4/18/2021
 */

public class Chapter4 {

    public static double testStaticMethod(final double x){
        return 5*x;
    }

    public double testInstanceMethod(){
        return 5.05;
    }

    public static void main(String[] args) {

        Chapter4 c = new Chapter4();
        double x = 10;
        System.out.println(testStaticMethod(x));
        System.out.println(c.testStaticMethod(4)); //possible to access status via instance
    }
}
