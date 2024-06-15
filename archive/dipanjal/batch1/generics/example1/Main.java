package com.dipanjal.batch1.generics.example1;

import com.dipanjal.batch1.mammal.Cat;
import com.dipanjal.batch1.mammal.Dog;

public class Main {

    public static void main(String[] args) {
        /*IntegerPrinter integerPrinter = new IntegerPrinter();
        integerPrinter.print(5);

        DoublePrinter doublePrinter = new DoublePrinter();
        doublePrinter.print(5.5);*/

        NumberPrinter<Integer> numberPrinter = new NumberPrinter<>();
        numberPrinter.print(5);

//        NumberPrinter<Cat> catNumberPrinter = new NumberPrinter<>();
//        catNumberPrinter.print(new Cat());
//        int x = 5;
//        Integer integer = 5;

        NumberPrinter<Integer> integerGenericPrinter = new NumberPrinter<>();
        integerGenericPrinter.print(10);

        NumberPrinter<Double> doubleGenericPrinter = new NumberPrinter<>();
        doubleGenericPrinter.print(10.5);

        GenericPrinter genericPrinter = new GenericPrinter();
        genericPrinter.printNumber(5);
        genericPrinter.printAnimal(new Cat());
        genericPrinter.printAnimal(new Dog());

    }
}
