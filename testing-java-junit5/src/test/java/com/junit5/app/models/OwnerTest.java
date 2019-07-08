package com.junit5.app.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    public void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Madrid");
        owner.setTelephone("123456789");

        assertAll("Properties Test",
                () -> assertAll("Person properties",
                           () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                           () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner properties",
                        () -> assertEquals("Madrid", owner.getCity(), "City did not match"),
                        () -> assertEquals("123456789", owner.getTelephone()))
                );

    }

}