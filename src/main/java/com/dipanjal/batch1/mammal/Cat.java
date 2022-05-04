package com.dipanjal.batch1.mammal;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {

    public Cat() {
        super.name = "Basic Cat";
        super.colour = "White";
        super.age = 3;
    }

    public Cat(String name, String colour, int age){
        super.name = name;
        super.colour = colour;
        super.age = age;
    }



    @Override
    public void eat() {
        System.out.println("I eat Fish");
    }

    @Override
    public String getName(){
        return super.name;
    }

    @Override
    public String getColour(){
        return super.colour;
    }

    @Override
    public int getAge(){
        return super.age;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.name = "Ponny123";
        cat.colour = "White";
        cat.age = 2;
    }
}
