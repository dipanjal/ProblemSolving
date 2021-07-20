package com.dipanjal.ocp.practiece.chapter9;

/**
 * @author dipanjal
 * @since 4/21/2021
 */

public class Product{
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
