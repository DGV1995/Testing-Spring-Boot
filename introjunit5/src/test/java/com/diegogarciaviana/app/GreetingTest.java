package com.diegogarciaviana.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GreetingTest {

    private Greeting greeting;

    // Before all the tests...
    @BeforeAll
    public static void beforeClass() {
        System.out.println("In Before All...");
    }

    // Before each test...
    @BeforeEach
    public void setUp() {
        System.out.println("In Before Each...");
        greeting = new Greeting();
    }

    @Test
    public void testHelloWorld() {
        assertEquals(greeting.helloWorld(), "Hello World");
    }

    @Test
    public void testHelloName() {
        assertEquals(greeting.helloWorld("Diego"), "Hello Diego");
        assertNotEquals(greeting.helloWorld("Diego"), "Hello Javi");
    }

    // After each test...
    @AfterEach
    public void tearDown() {
        System.out.println("In After Each...");
    }

    // After all the tests...
    @AfterAll
    public static void afterClass() {
        System.out.println("In After All....");
    }

}
