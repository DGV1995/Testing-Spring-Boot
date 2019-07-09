package diegogarciaviana.unit5.controllers;

import diegogarciaviana.unit5.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test Proper View name is returned for index page") // This will be the text that will appear in the tests window
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");

        // Using AssertJ library
        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        // This method should throws an exception
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Disabled("Demo of timeout")
    @Test
    public void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled
    @Test
    public void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here 23232323232");
        });
    }

    @Test
    public void testAssumptionTrue() {
        // If it fails, it won't break everything
        assumeTrue("GURU".equalsIgnoreCase("GURU_RUNTIME"));
    }

    @Test
    public void testAssumptionTrueIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    // It will run if your OS is MacOS
    @EnabledOnOs(OS.MAC)
    @Test
    public void testMeOnMacOS() {}

    @EnabledOnOs(OS.WINDOWS)
    @Test
    public void testMeOnWindows() {}

    // It will run if your JRE is Java 8
    @EnabledOnJre(JRE.JAVA_8)
    @Test
    public void testMeOnJava8() {}

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    public void testMeOnJava11() {}

    // It will run if the user name is "diegogarcia-viana"
    @EnabledIfEnvironmentVariable(named = "USER", matches = "diegogarcia-viana")
    @Test
    public void testIfUserDiego() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    public void testIfUserFred() {}

}