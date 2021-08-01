package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class PizzaMaker {

    public static void main(String[] args) {
        Pizza customPizza = new Corn(
                new Onion(
                        new Mushroom(
                                new Margarita(
                                        new ClassicPizza()
                                )
                        )
                )
        );

        System.out.println("Ingredients: "+customPizza.getDescription());
        System.out.println("Total Cost: "+customPizza.getCost());
    }
}
