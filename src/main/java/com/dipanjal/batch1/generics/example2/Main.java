package com.dipanjal.batch1.generics.example2;

import com.dipanjal.batch1.mammal.Animal;
import com.dipanjal.batch1.mammal.Cat;
import com.dipanjal.batch1.mammal.Dog;

public class Main {

    public static void main(String[] args) {

        House house = new House();

        /*
         * if we have to add only cats or only dogs
         * we can not restrict the animal type like only Cat or Only Dog
         * we also have to cast the object into a specific type to access the fields
         */
        /*Object cat = new Cat("Ponny", "White", 2);
        Object dog = new Dog("Robert", "Brown", 6);
        house.add(cat);
        house.add(dog);

        Integer num = 5;
        house.add(num);*/

        /*
         * if we have to add only cats or only dogs
         * we can not restrict the animal type here
         * like only Cat or Only Dog
         */
//        house.add(new Cat("Ponny", "White", 2));
//        house.add(new Dog("Robert", "Brown", 6));

        AnimalHouse<Cat> catHouse = new AnimalHouse<>();
        catHouse.add(new Cat("Ponny", "White", 2));
//        catHouse.add(new Dog());
        Cat myCat = catHouse.get();

        AnimalHouse<Dog> dogHouse = new AnimalHouse<>();
        dogHouse.add(new Dog("Robert", "Brown", 6));
        dogHouse.add(new Dog("Robert", "Brown", 6));
        Dog myDog = dogHouse.get();
    }
}
