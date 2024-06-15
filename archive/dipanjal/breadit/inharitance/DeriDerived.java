package com.dipanjal.breadit.inharitance;

/**
 * @author dipanjal
 * @since 5/26/2021
 */

public class DeriDerived extends Derived {
    private String fullName;

    public DeriDerived() {
        System.out.println("DeriDerived");
        super.hasChild = true;
//        super.setUserName("User_Name");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static void main(String[] args) {
        Derived d = new DeriDerived();
    }
}
