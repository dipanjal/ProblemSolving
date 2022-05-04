package com.dipanjal.batch1.generics.example1;

import com.dipanjal.batch1.mammal.Animal;

public class GenericPrinter {

    public <T extends Number> void printNumber(T t) {
        System.out.println(t);
    }
    public <T extends Animal> void printAnimal(T t) {
        System.out.println(t.getName());
    }
}
