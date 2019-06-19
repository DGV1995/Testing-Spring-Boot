package com.diegogarciaviana.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five  = new Dollar(5);
        Dollar result = five.times(2);
        //five.times(2);
        assertEquals(10, result.getAmount());
    }

    @Test
    public void testEquality() {
        assertEquals(new Dollar(5), new Dollar(5));
        assertNotEquals(new Dollar(8), new Dollar(10));
    }

}
