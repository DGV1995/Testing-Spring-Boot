package com.diegogarciaviana.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    public void testMultiplication() {

        Money five  = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

        five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));

    }

    @Test
    public void testEquality() {

        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(8), Money.dollar(10));

        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(8), Money.franc(10));

        assertNotEquals(Money.dollar(5), Money.franc(5));

    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {

        Money five = Money.dollar(5);
        Expression sum = five.plus(five);

        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(10), reduced);

    }

    @Test
    public void testPlusReturnSum() {

        Money five = Money.dollar(5);
        Sum sum = five.plus(five);

        //Sum sum = (Sum) result;

        assertEquals(five, sum.getAddment());
        assertEquals(five, sum.getAugmend());

    }

    @Test
    public void testReduceSum() {

        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();

        Expression reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), reduced);

    }

}
