package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    // Inject the mock object SpecialtyRepository in a SpecialitySDJpaService object
    @InjectMocks
    SpecialitySDJpaService service;


    @Test
    void deleteById() {
        service.deleteById(1L);
        service.deleteById(1L);

        // Verify that the repository deleteById() method is executed twice
        // We execute deleteById() method of the service twice, so it must be executed twice
        // in the repository too
        verify(specialtyRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeast() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atMost(5)).deleteById(1L);
    }

    @Test
    void deleteByIdNever() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
        // Verify that we never use deleteById() method with the parameter 5
        verify(specialtyRepository, never()).deleteById(5L);
    }

    @Test
    void delete() {
        service.delete(new Speciality());
    }
}