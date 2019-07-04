package com.diegogarciaviana.testing;

public class Sum implements Expression {

    private Money augmend;
    private Money addment;

    public Sum(Money augmend, Money addment) {
        this.augmend = augmend;
        this.addment = addment;
    }

    public Money getAugmend() {
        return augmend;
    }

    public Money getAddment() {
        return addment;
    }

    public Money reduce(String toCurrency) {
        int amount = augmend.getAmount() + addment.getAmount();
        return new Money(amount, toCurrency);
    }

}
