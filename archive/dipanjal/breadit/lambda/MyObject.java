package com.dipanjal.breadit.lambda;

/**
 * @author dipanjal
 * @since 5/26/2021
 */

public class MyObject {

    public void addHandler(MyHandler handler){
        handler.handle("My first functional interface test");
    }

    public static void main(String[] args) {
        MyObject obj = new MyObject();
        obj.addHandler(System.out::println);
    }
}
