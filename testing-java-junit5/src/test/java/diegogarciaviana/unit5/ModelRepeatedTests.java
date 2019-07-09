package diegogarciaviana.unit5;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }

}
