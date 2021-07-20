package com.dipanjal.ocp.practiece.chapter7.clonabletest;

import com.dipanjal.ocp.practiece.chapter7.TestImpl;
import com.dipanjal.ocp.practiece.chapter7.TestInterface;
import com.dipanjal.ocp.practiece.chapter7.TestInterface2;

/**
 * @author dipanjal
 * @since 4/19/2021
 */

public class Main {

    public static void main(String[] args) {
        Product p1 = new Product("Tea", 5.5);
        try {
            Product p2 = (Product) p1.clone();
            p2.setName("Coffee");
            p2.setPrice(10.00);

            System.out.println(p1.toString());
            System.out.println(p2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        TestImpl impl = new TestImpl();
        TestInterface testInterface = impl; //type promotion
        TestImpl impl2 = (TestImpl) testInterface; //down casting
        TestInterface2 interface2 = (TestInterface2) testInterface;
        //TestInterface2 testInterface2 = (TestInterface2) testInterface; //can't cast
//        but if TestImpl implements both TestInterface, TestInterface2 then casting possible. because same type.

    }
}
