package com.dipanjal.batch1.generics.example1;

public class NumberPrinter<T extends Number> {

    public void print(T t) {
        System.out.println(t);
    }
}
