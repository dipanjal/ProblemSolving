package com.dipanjal.batch1.currencyconverter;

public class EURCurrencyConverter extends CurrencyConverter {

    @Override
    public double convert(double amt) {
        System.out.println("EUR Conversion");
        return amt * 100.00;
    }
}
