package com.dipanjal.batch1.generics.example2;

import com.dipanjal.batch1.mammal.Animal;
import com.dipanjal.batch1.mammal.Cat;
import com.dipanjal.batch1.mammal.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS example
 * PE => Producer Extends => Upper Bound
 * CS => Consumer Super => Lower Bound
 */
public class Aggregator {


    /**
     * Producer Extends, Receives Upper Bounded Wildcard
     * @param numberList passed for producing something out of the list
     * @return aggregation of a type of Animal List
     * List<Dog> or List<Cat>
     */
    public int sum(List<? extends Animal> numberList) {
        int ages = 0;
        for (Animal animal : numberList){
            ages += animal.getAge();
        }
        return ages;
    }

    public static void main(String[] args) {

        /*
         * This add Method is a Consumer Type method
         * it's only consuming any types of number
         * Consumer Super | Lower Bounded Wildcard
         * List<Animal> or List<? super Animal> are the same
         */
        List<? super Animal> animals = new ArrayList<>(); //any type of Animals, Lower bounded wildcard
        animals.add(new Cat());
        animals.add(new Dog());

        Aggregator aggregator = new Aggregator();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Robert", "Gray", 10));
        dogs.add(new Dog("Fredric", "Brown", 5));
        int dogAges = aggregator.sum(dogs);
        System.out.println(dogAges);

        /*
         * Supports any List of Child of Animals
         */
        List<? extends Animal> upperList = new ArrayList<>();
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        upperList = dogs;

        List<Cat> cats = List.of(new Cat(), new Cat("C1", "White", 4));
        List<Cat> cats2 = List.of(new Cat("c2", "", 4));
        List<Dog> dogs1 = List.of(new Dog("c2", "", 4));
        cats.addAll(cats2);
//        cats.addAll(dogs1); // we can't add List of Dog in List of Cat

    }
}
