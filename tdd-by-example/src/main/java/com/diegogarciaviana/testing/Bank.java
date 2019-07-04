package com.diegogarciaviana.testing;

public class Bank {

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }

}
