package com.dipanjal.batch1.currencyconverter;

public class CurrencyConverterFactory {

    public CurrencyConverter getConverter(String type){
        if(type.equals("USD")) {
            return new USDCurrencyConverter();
        } else if (type.equals("INR")) {
            return new INRCurrencyConverter();
        } else if (type.equals("EUR")) {
            return new EURCurrencyConverter();
        }
        return null;
    }
}
