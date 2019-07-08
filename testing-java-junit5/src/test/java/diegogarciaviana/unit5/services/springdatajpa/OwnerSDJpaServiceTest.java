package diegogarciaviana.unit5.services.springdatajpa;

import diegogarciaviana.unit5.model.Owner;
import diegogarciaviana.unit5.repositories.OwnerRepository;
import diegogarciaviana.unit5.repositories.PetRepository;
import diegogarciaviana.unit5.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    public void setUp() {
        service = new OwnerSDJpaService(null, null, null);
    }

    @Disabled // This test will be ignored
    @Test
    void findByLastName() {
        Owner foundOwner = service.findByLastName("Buck");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}