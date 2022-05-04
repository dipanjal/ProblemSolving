package com.dipanjal.batch1.generics.example1;

import com.dipanjal.batch1.mammal.Animal;

public class AnimalPrinter<T extends Animal> {

    public void print(T t) {
        System.out.println();
    }
}
