package com.dipanjal.breadit.inharitance;

/**
 * @author dipanjal
 * @since 5/26/2021
 */

public class Derived extends Base {
    protected boolean hasChild;
    private final String userName;
    private static String CONSTANT_FIELD;

    static {
        CONSTANT_FIELD = "STATIC VALUE";
    }

    public Derived() {
        System.out.println("Derived");
        this.userName = "final_uname";
    }

    public String getUserName() {
        return userName;
    }

    public static void setConstantField(String value){
        CONSTANT_FIELD = value;
    }

    public static String getConstantField(){
        return Derived.CONSTANT_FIELD;
    }
}
