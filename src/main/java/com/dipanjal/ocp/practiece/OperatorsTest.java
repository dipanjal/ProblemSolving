package com.dipanjal.ocp.practiece;

import java.util.Objects;

/**
 * @author dipanjal
 * @since 4/17/2021
 */

public class OperatorsTest {
    public boolean check(boolean var){
        System.out.println(String.format("Check(%s)", var));
        return var;
    }
    public void logicalAndVsBitwiseAndTest() {
        boolean flag = true;
        Objects obj = null;

        boolean logicalAnd = obj != null && check(flag); //short circuit evaluation. here the obj != null is false, so check() will not be evaluated.
        System.out.println("Logical And: "+logicalAnd);

        boolean bitwiseAnd = obj != null & check(flag); //Full Evaluation. Doesn't matter the obj is null or not. Both conditions will be evaluated.
        System.out.println("Bitwise And: "+bitwiseAnd);
    }

    public void xorTest(boolean diesel, boolean manual){
        /*
        Suppose a car can have either diesel or manual engine.
        Both can't be present at the same time
         */
        boolean logicalCheck = (diesel && !manual) || (!diesel && manual);
        boolean bitwiseCheck = diesel ^ manual;

        System.out.println("Logical :"+ logicalCheck);
        System.out.println("Bitwise :"+ bitwiseCheck);
    }

    public static void main(String[] args) {
        OperatorsTest operatorsTest = new OperatorsTest();
//        operatorsTest.logicalAndVsBitwiseAndTest();
        operatorsTest.xorTest(true, true);
        operatorsTest.xorTest(true, false);
        operatorsTest.xorTest(false, false);
    }
}
