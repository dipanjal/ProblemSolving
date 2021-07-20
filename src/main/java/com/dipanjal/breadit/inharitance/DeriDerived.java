package com.dipanjal.breadit.inharitance;

/**
 * @author dipanjal
 * @since 5/26/2021
 */

public class DeriDerived extends Derived {
    public DeriDerived() {
        System.out.println("DeriDerived");
    }

    public static void main(String[] args) {
        Derived d = new DeriDerived();
    }
}
