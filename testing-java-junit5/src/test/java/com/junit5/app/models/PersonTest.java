package com.junit5.app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person(1L, "Peter", "Parker");
    }

    /**
    @Test
    public void testFirstName() {
        assertEquals("Peter", person.getFirstName());
        assertNotEquals("Diego", person.getFirstName());
    }

    @Test
    public void testLastName() {
        assertEquals("Parker", person.getLastName());
        assertNotEquals("García", person.getLastName());
    }
    **/

    @Test
    public void groupedAssertions() {
        // We can do several assertions at the same time
        assertAll("Test Props Set",
                () -> assertEquals("Peter", person.getFirstName(), "Wrong first name!"),
                () -> assertEquals("Parker", person.getLastName(), "Wrong last name!"));
    }

}