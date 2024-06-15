package com.dipanjal.designPatterns.decorator;

/**
 * @author dipanjal
 * @since 0.0.1
 */

/**
 * Toping Decorator is the Key player here.
 * It is helps to add cherry on top rather than creating a sub-class for cherry
 * It provides dynamic way to modifying object behaviour in runtime
 */
public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza newItem) {
        this.pizza = newItem;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
