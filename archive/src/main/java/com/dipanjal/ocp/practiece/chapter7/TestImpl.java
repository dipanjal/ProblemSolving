package com.dipanjal.ocp.practiece.chapter7;

/**
 * @author dipanjal
 * @since 4/19/2021
 */

public class TestImpl implements TestInterface, TestInterface2 {

    @Override
    public void testCode() {
       boolean x = TestInterface.MAX_PERIOD_FINAL != null;
    }

    @Override
    public void print(Object obj) {

    }

    @Override
    public void common() {

    }
}
