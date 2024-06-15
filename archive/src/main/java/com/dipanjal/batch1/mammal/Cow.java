package com.dipanjal.batch1.mammal;

public class Cow extends Animal {

    @Override
    public void eat() {
        System.out.println("I eat Grass");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getColour() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.eat();
    }


}
