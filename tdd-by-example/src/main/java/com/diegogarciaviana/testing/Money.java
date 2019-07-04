package com.diegogarciaviana.testing;

import java.util.Objects;

public class Money implements Expression {

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

    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(this.amount/bank.rate(this.currency, to), to);
    }

}
