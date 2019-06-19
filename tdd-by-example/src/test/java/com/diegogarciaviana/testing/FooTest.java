package com.diegogarciaviana.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    @Test
    public void getBar() {

        Foo foo = new Foo();
        String result = foo.getBar();
        assertEquals("FooBar", result);

    }

}