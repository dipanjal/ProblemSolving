package com.dipanjal.batch1.generics.example2;

import com.dipanjal.batch1.mammal.Animal;

public class House {

    /*
     * if we can to add only cats or only dogs
     * we can not restrict the animal type here
     * we also have to cast the object into a specific type to access the fields
     */
    public void add(Object obj) {
        Animal animal = (Animal) obj;
        System.out.println("Hi! My name is "+ animal.getName());
        System.out.println("Kind: "+ animal.getClass().getSimpleName());
        System.out.println("I am "+ animal.getAge()+ " Years old");
        animal.eat();
        System.out.println("----------------------");
    }

    /*
    * if we can to add only cats or only dogs
    * we can not restrict the animal type here
     */
    public void add(Animal animal) {
        System.out.println("Hi! My name is "+ animal.getName());
        System.out.println("Kind: "+ animal.getClass().getSimpleName());
        System.out.println("I am "+ animal.getAge()+ " Years old");
        animal.eat();
        System.out.println("----------------------");
    }
}
