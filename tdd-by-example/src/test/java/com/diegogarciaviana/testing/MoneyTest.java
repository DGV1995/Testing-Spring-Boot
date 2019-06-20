package com.diegogarciaviana.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    public void testMultiplicationDollar() {
        Dollar five  = new Dollar(5);
        Dollar result = five.times(2);
        assertEquals(new Dollar(10), result);
    }

    @Test
    public void testEqualityDollar() {
        assertEquals(new Dollar(5), new Dollar(5));
        assertNotEquals(new Dollar(8), new Dollar(10));
    }

    @Test
    public void testMultiplicationFranc() {
        Franc five = new Franc(5);
        Franc result = five.times(2);
        assertEquals(new Franc(10), result);
        result = five.times(3);
        assertEquals(new Franc(15), result);
    }

    @Test void testEqualityFranc() {
        assertEquals(new Franc(5), new Franc(5));
        assertNotEquals(new Franc(8), new Franc(10));
    }

}
