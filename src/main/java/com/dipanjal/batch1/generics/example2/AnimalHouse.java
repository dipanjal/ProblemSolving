package com.dipanjal.batch1.generics.example2;

import com.dipanjal.batch1.mammal.Animal;

import java.io.Serializable;

public class AnimalHouse<T extends Animal & Serializable> {

    private T animal;

    public AnimalHouse() {
        System.out.println("Generic House for "+ this.getClass().getSimpleName() +" Created");
    }

    /*
    * if we can to add only cats or only dogs
    * we can restrict now
     */
    public void add(T animal) {
        this.animal = animal;
        System.out.println("Hi! My name is "+ animal.getName());
        System.out.println("Kind: "+ animal.getClass().getSimpleName());
        System.out.println("I am "+ animal.getAge()+ " Years old");
        animal.eat();
        System.out.println("----------------------");
    }

    public T get() {
        return animal;
    }
}
