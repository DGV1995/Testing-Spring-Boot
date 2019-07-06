package com.junit.app;

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
        //assertTrue("notimplemented".equals(controller.oupsHandler()), () -> "Wrong message");
    }
}