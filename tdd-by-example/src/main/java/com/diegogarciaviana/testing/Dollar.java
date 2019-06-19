package com.diegogarciaviana.testing;

public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int n) {
        return new Dollar(amount * n);
    }

    public int getAmount() {
        return amount;
    }

    public boolean equals(Object object) {
        Dollar dollar = (Dollar) object;
        return amount == dollar.getAmount();
    }

}
