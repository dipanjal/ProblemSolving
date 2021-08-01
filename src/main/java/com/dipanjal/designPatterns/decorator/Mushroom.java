package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class Mushroom extends ToppingDecorator {

    public Mushroom(Pizza newItem) {
        super(newItem);
        System.out.println("Adding Mushroom");
    }

    @Override
    public String getDescription() {
        return super.pizza.getDescription().concat(", Mushroom");
    }

    @Override
    public double getCost() {
        return super.pizza.getCost() + 0.5;
    }
}
