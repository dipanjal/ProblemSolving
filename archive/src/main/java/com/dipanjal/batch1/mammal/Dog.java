package com.dipanjal.batch1.mammal;

import java.io.Serializable;

public class Dog extends Animal implements Serializable {

    public Dog() {
        super.name = "Basic Dog";
        super.colour = "Black";
        super.age = 5;
    }

    public Dog(String name, String colour, int age){
        super.name = name;
        super.colour = colour;
        super.age = age;
    }

    @Override
    public void eat() {
        System.out.println("I eat Meat");
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String getColour() {
        return super.colour;
    }

    @Override
    public int getAge() {
        return super.age;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Harry";
        System.out.println(dog.name);
        dog.eat();
    }
}
