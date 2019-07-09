package diegogarciaviana.unit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // => Necessary to implement @BeforeAll method
@Tag("controllers")
public interface ControllerTests {

    // This will be execute before each test that implements this ControllerTests interface (IndexControllerTest, VetControllerTest)
    @BeforeAll
    default void beforeAll() {
        System.out.println("This is a Controller Test");
    }

}
