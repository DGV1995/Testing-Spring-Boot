package com.diegogarciaviana.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @Test
    public void testHelloWorld() {
        Greeting greeting = new Greeting();
        assertEquals(greeting.helloWorld(), "Hello World");
    }

    @Test
    public void testHelloName() {
        Greeting greeting = new Greeting();
        assertEquals(greeting.helloWorld("Diego"), "Hello Diego");
    }

}
