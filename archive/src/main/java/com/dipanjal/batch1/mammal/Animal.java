package com.dipanjal.batch1.mammal;

public abstract class Animal {
    protected String name;
    protected String colour;
    protected int age;

    public abstract void eat();
    public abstract String getName();
    public abstract String getColour();
    public abstract int getAge();
}