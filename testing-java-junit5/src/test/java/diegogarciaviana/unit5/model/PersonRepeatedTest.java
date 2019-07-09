package diegogarciaviana.unit5.model;

import diegogarciaviana.unit5.ModelRepeatedTests;
import diegogarciaviana.unit5.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepeatedTests {

    // displayName, currentRepetition and totaRepetitions are placeholders
    @RepeatedTest(value = 5, name = "{displayName}: {currentRepetition} - {totalRepetitions}") // This test will be repeated 10 times
    @DisplayName("My Repeated Test")
    public void myRepeatedTest() {
        // todo - impl
    }

    @RepeatedTest(value = 5)
    @DisplayName("My Repeated Test with Dependency Injection")
    public void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition}/{totalRepetitions}")
    @DisplayName("My Assigment Repeated")
    public void myAssigmentRepeated() {
        // todo - impl
    }

}
