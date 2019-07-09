package diegogarciaviana.unit5;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // => Necessary to implement @BeforeAll method
@Tag("model")
public interface ModelTests {

    // This will be execute before each test that implements this ModelTests interface (PersonTest, OwnerTest)
    @BeforeEach
    default void beforeAll(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }

}
