package com.diegogarciaviana.testing;

public class Franc {

    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Franc times(int n) {
        return new Franc(amount * n);
    }

    public boolean equals(Object object) {
        Franc franc = (Franc) object;
        return amount == franc.getAmount();
    }

}
