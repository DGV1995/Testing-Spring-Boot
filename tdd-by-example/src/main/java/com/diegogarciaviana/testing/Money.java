package com.diegogarciaviana.testing;

public abstract class Money {

    protected int amount;

    public int getAmount() {
        return amount;
    }

    public abstract Money times(int multiplier);

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    // This method allows to us to compare two objects in the tests
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.getAmount() && this.getClass().equals(object.getClass());
    }

}
