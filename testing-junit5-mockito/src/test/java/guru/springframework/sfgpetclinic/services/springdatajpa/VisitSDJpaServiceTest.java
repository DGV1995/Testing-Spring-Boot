package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository repository;

    @InjectMocks
    private VisitSDJpaService service;

    @Test
    void findAll() {
        // Given
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());
        given(repository.findAll()).willReturn(visits);

        // When
        Set<Visit> foundVisits = service.findAll();

        // Then
        assertThat(foundVisits).isNotNull();
        assertTrue(visits.size() == 1);
        then(repository).should().findAll();
    }

    @Test
    void findById() {
        // Given
        Visit visit = new Visit();
        given(repository.findById(anyLong())).willReturn(Optional.of(visit));

        // When
        Visit foundVisit = service.findById(1L);

        // Then
        assertThat(foundVisit).isNotNull();
        then(repository).should().findById(anyLong());
    }

    @Test
    void save() {
        // Given - none
        Visit visit = new Visit();

        // When
        service.save(visit);

        // Then
        then(repository).should().save(any(Visit.class));
    }

    @Test
    void delete() {
        // Given - none
        Visit visit = new Visit();

        // When
        service.delete(visit);

        // Then
        then(repository).should().delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        // Given - none

        // When
        service.deleteById(1L);

        // Then
        then(repository).should().deleteById(anyLong());
    }

}