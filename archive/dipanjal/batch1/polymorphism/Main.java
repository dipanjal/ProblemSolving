package com.dipanjal.batch1.polymorphism;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.whoAmI();

        animal = new Dog();
        animal.whoAmI();
    }
}
