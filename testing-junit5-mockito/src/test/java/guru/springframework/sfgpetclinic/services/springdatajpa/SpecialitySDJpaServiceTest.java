package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    // Inject the mock object SpecialtyRepository in a SpecialitySDJpaService object
    @InjectMocks
    SpecialitySDJpaService service;

    // Test Driven Development (TDD)
    @Test
    void findById() {
        Speciality speciality = new Speciality();
        when(specialtyRepository.findById(anyLong())).thenReturn(Optional.of(speciality));

        Speciality foundSpeciality = service.findById(1L);
        assertThat(foundSpeciality).isNotNull();

        // Verify that mock implementation was called once, using argument matcher
        verify(specialtyRepository).findById(anyLong());
    }

    // Behaviour Driven Development (different syntax)
    @Test
    void findByIdTest() {
        // Given
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(anyLong())).willReturn(Optional.of(speciality));

        // When
        Speciality foundSpeciality = service.findById(1L);

        // Then
        //verify(specialtyRepository).findById(anyLong());
        assertThat(foundSpeciality).isNotNull();
        then(specialtyRepository).should().findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteByObject() {
        // Given
        Speciality speciality = new Speciality();

        // When
        service.delete(speciality);

        // Verify method with argument matcher
        // Then
        then(specialtyRepository).should().delete(speciality);
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteById() {
        //Given - none

        //When
        service.deleteById(1L);
        service.deleteById(1L);

        // Verify that the repository deleteById() method is executed twice
        // We execute deleteById() method of the service twice, so it must be executed twice
        // in the repository too
        // Then
        then(specialtyRepository).should(times(2)).deleteById(anyLong());
        //verify(specialtyRepository, times(2)).deleteById(anyLong());
    }

    @Test
    void deleteByIdAtLeast() {
        // Given - none

        // When
        service.deleteById(1L);
        service.deleteById(1L);

        // Then
        then(specialtyRepository).should(atLeastOnce()).deleteById(anyLong());
        //verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        // Given - none

        // When
        service.deleteById(1L);
        service.deleteById(1L);

        // Then
        then(specialtyRepository).should(atMost(2)).deleteById(anyLong());
        //verify(specialtyRepository, atMost(2)).deleteById(1L);
    }

    @Test
    void deleteByIdNever() {
        // Given - none

        // When
        service.deleteById(1L);
        service.deleteById(1L);

        // Then
        then(specialtyRepository).should(atLeastOnce()).deleteById(anyLong());
        then(specialtyRepository).should(never()).deleteById(5L); // Verify that we never use deleteById() method with the parameter 5
        //verify(specialtyRepository, atLeastOnce()).deleteById(1L);
        //verify(specialtyRepository, never()).deleteById(5L);
    }

    @Test
    void delete() {
        // Given - none

        // When
        service.delete(new Speciality());

        // Then
        then(specialtyRepository).should().delete(any(Speciality.class));
    }
}