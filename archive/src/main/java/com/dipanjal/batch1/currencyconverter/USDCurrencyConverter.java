package com.dipanjal.batch1.currencyconverter;

public class USDCurrencyConverter extends CurrencyConverter {

    @Override
    public double convert(double amt) {
        System.out.println("USD Conversion");
        double rate = 80.00;
        return amt * rate;
    }
}
