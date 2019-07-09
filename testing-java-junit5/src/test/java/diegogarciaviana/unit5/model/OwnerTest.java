package diegogarciaviana.unit5.model;

import diegogarciaviana.unit5.CustomArgsProvider;
import diegogarciaviana.unit5.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));

        // Using Hamcrest library
        assertThat(owner.getCity(), is("Key West"));

    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    public void testValueSource(String val) {
        // This will print the strings defined in @ValueSource (3 repetitions, one for each value)
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    public void enumTest(OwnerType ownerType) {
        // This will print the values in the enum OwnerType
        System.out.println(ownerType);

    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 3"
    })
    public void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName ("CSV From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources="/input.csv", numLinesToSkip = 1) // To skip the header (Name, Val1, Val2)
    public void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    public void fromMethodTest(String stateName, int val1, int val2) {
        // This test will print the args returned in the getArgs() method
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(Arguments.of("FL", 1, 1),
                         Arguments.of("OH", 2, 2),
                         Arguments.of("MI", 3, 3));
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    // JUnit will look for a CustomArgsProvider class
    public void fromCustomProviderTest(String stateName, int val1, int val2) {
        // This test will print the args returned in the getArgs() method
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

}