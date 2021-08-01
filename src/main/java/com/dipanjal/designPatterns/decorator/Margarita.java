package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class Margarita extends ToppingDecorator {

    public Margarita(Pizza newItem) {
        super(newItem);
        System.out.println("Adding Margarita");
    }

    @Override
    public String getDescription() {
        return super.pizza.getDescription().concat(", Margarita");
    }

    @Override
    public double getCost() {
        return super.pizza.getCost() + 1.0;
    }
}
