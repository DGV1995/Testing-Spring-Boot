package com.diegogarciaviana.testing;

public class Sum implements Expression {

    private Expression augmend;
    private Expression addment;

    public Sum(Expression augmend, Expression addment) {
        this.augmend = augmend;
        this.addment = addment;
    }

    public Expression getAugmend() {
        return augmend;
    }

    public Expression getAddment() {
        return addment;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = this.augmend.reduce(bank, to).getAmount() + this.addment.reduce(bank, to).getAmount();
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        // It does, for example, (5 + 2) * 3 = 5*3 + 2*3 = 21 ==> 7 * 3 = 21
        return new Sum(augmend.times(multiplier), addment.times(multiplier));
    }

}
