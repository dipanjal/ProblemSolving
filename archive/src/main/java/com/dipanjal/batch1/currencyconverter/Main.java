package com.dipanjal.batch1.currencyconverter;

public class Main {

    public static void main(String[] args) {
        double amount = 40;
        System.out.println(convertByType("EUR", amount));
        System.out.println(convertByType("INR", amount));
        System.out.println(convertByType("USD", amount));
    }

    public static double convertByType(String type, double amt) {
        CurrencyConverterFactory factory = new CurrencyConverterFactory();
        CurrencyConverter currencyConverter = factory.getConverter(type);
        return currencyConverter.convert(amt);
    }
}
