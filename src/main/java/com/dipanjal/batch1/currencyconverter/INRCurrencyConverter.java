package com.dipanjal.batch1.currencyconverter;

public class INRCurrencyConverter extends CurrencyConverter {

    @Override
    public double convert(double amt) {
        System.out.println("INR Conversion");
        double rate = 2.00;
        return amt * rate;
    }
}
