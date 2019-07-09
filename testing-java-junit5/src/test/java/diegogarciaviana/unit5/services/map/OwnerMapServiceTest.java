package diegogarciaviana.unit5.services.map;

import diegogarciaviana.unit5.model.Owner;
import diegogarciaviana.unit5.model.PetType;
import diegogarciaviana.unit5.services.PetService;
import diegogarciaviana.unit5.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Owner Map Service Test -")
class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private PetTypeService petTypeService;
    private PetService petService;

    @BeforeEach
    public void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
        System.out.println("First BeforeEach");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    public void ownerAreZero() {
        assertThat(ownerMapService.findAll().size()).isZero();
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes {

        @BeforeEach
        public void setUp() {
            PetType pet1 = new PetType(1L, "Dog");
            PetType pet2 = new PetType(2L, "Cat");
            petTypeService.save(pet1);
            petTypeService.save(pet2);
            System.out.println("Second BeforeEach");
        }

        @Test
        public void testPetCount() {
            assertThat(petTypeService.findAll().size()).isEqualTo(2);
        }

        @DisplayName("Save Owners Test - ")
        @Nested
        class SaveOwnersTests {

            @BeforeEach
            public void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("Saved Owners BeforeEach");
            }

            @Test
            public void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Buck");
                Owner savedOwner = ownerMapService.save(owner);
                assertThat(savedOwner).isNotNull();
                //assertThat(savedOwner).isEqualTo(owner);
            }

            @DisplayName("Find Owners Tests - ")
            @Nested
            class FindOwnersTests {

                @DisplayName("Find Owner")
                @Test
                public void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertThat(foundOwner).isNotNull();
                }

                @DisplayName("Find Owner Not Found")
                @Test
                public void findOwnerNotFound() {
                    Owner foundOwner = ownerMapService.findById(2L);
                    assertThat(foundOwner).isNull();
                }

            }

        }

    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    public void ownersAreStillZero() {
        assertThat(ownerMapService.findAll().size()).isZero();
    }

}