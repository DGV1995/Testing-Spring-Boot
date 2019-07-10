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
import static org.mockito.Mockito.*;

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
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    void findById() {
        // Given
        Visit visit = new Visit();
        given(repository.findById(1L)).willReturn(Optional.of(visit));

        // When
        Visit foundVisit = service.findById(1L);

        // Then
        assertThat(foundVisit).isNotNull();
        then(repository).should().findById(anyLong());
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    void save() {
        // Given - none

        // When
        service.save(new Visit());

        // Then
        then(repository).should().save(any(Visit.class));
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    void delete() {
        // Given - none

        // When
        service.delete(new Visit());

        // Then
        then(repository).should().delete(any(Visit.class));
        then(repository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteById() {
        // Given - none

        // When
        service.deleteById(1L);

        // Then
        then(repository).should().deleteById(anyLong());
        then(repository).shouldHaveNoMoreInteractions();
    }

}