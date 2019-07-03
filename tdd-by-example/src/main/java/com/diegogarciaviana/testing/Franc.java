package com.diegogarciaviana.testing;

public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }

    public Money times(int n) {
        return new Franc(this.getAmount() * n);
    }

}
