package com.dipanjal.breadit.inharitance;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class TestClass {


    public static void main(String[] args) {
        Derived d = new Derived();
        System.out.println(d.getUserName());
        d.setConstantField("MY CONSTANT FIELD");
        System.out.println(d.getConstantField());
    }
}
