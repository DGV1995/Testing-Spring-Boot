package com.diegogarciaviana.testing;

public class Bank {

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public void addRate(String from, String to, int rate) {

    }

    public float rate(String from, String to) {
        return from.equals("CHF") && to.equals("USD") ? 2:1;
    }

}
