package diegogarciaviana.unit5.controllers;

import diegogarciaviana.unit5.fauxspring.Model;
import diegogarciaviana.unit5.fauxspring.ModelMapImpl;
import diegogarciaviana.unit5.model.Vet;
import diegogarciaviana.unit5.services.VetService;
import diegogarciaviana.unit5.services.map.SpecialityMapService;
import diegogarciaviana.unit5.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    private VetService vetService;
    private SpecialityMapService specialityService;
    private VetController vetController;

    @BeforeEach
    public void setUp() {
        specialityService = new SpecialityMapService();
        vetService = new VetMapService(specialityService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Joe", "Buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);
        assertEquals("vets/index", view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);

    }
}