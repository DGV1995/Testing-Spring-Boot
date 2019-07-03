package com.diegogarciaviana.testing;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Money times(int n) {
        return new Dollar(this.getAmount() * n);
    }

}
