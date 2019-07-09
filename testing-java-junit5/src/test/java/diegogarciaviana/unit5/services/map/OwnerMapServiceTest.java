package diegogarciaviana.unit5.services.map;

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
    }

    @DisplayName("Verify Zero Owners")
    @Test
    public void ownerAreZero() {
        assertThat(ownerMapService.findAll().size()).isZero();
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes {}

    @DisplayName("Verify Still Zero Owners")
    @Test
    public void ownersAreStillZero() {
        assertThat(ownerMapService.findAll().size()).isZero();
    }

}