package com.dipanjal.batch1.mammal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        List<? extends Animal> animals = main.add(new Dog(), new Cat());
//        animals.add(new Cat());

    }

    public <T extends Animal> List<? extends Animal> add(T... types) {
        List<Animal> animals = new ArrayList<>();
        for(int i=0; i<types.length; i++){
            animals.add(types[i]);
        }
        return animals;
    }
}
