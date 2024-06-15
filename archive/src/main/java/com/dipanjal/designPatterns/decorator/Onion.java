package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class Onion extends ToppingDecorator {

    public Onion(Pizza newItem) {
        super(newItem);
        System.out.println("Adding Onion");
    }

    @Override
    public String getDescription() {
        return super.pizza.getDescription().concat(", Onion");
    }

    @Override
    public double getCost() {
        return super.pizza.getCost() + 0.5;
    }
}
