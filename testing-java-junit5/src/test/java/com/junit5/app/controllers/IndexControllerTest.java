package com.junit5.app.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController controller;

    @BeforeEach
    public void setUp() {
        controller = new IndexController();
    }

    @Test
    public void testIndex() {
        assertEquals("index", controller.index());
        assertEquals("indexed", controller.index(), "Wrong view returned");
    }

    @Test
    public void testOupsHandler() {
        // We can also use lambda expressions
        assertTrue(controller.oupsHandler().equals("notimplemented"), () -> "This is some expensive Message to build for my test");
    }

}