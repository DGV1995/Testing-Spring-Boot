package com.diegogarciaviana.testing;

public class Money {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    // This method allows to us to compare two objects in the tests
    public boolean equals(Object object) {
        Money money = (Money) object;
        return (this.amount == money.getAmount() && this.currency == money.currency());
    }

    public Money times(int multiplier) {
        return new Money(this.getAmount() * multiplier, this.currency());
    }
}
