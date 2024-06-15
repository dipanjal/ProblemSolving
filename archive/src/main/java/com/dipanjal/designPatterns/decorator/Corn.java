package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class Corn extends ToppingDecorator {

    public Corn(Pizza newItem) {
        super(newItem);
        System.out.println("Adding Corn");
    }

    @Override
    public String getDescription() {
        return super.pizza.getDescription().concat(", Corn");
    }

    @Override
    public double getCost() {
        return super.pizza.getCost() + 1.0;
    }
}
