package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class ClassicPizza implements Pizza {

    public ClassicPizza() {
        System.out.println("Thin Dough");
    }

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}
