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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository repository;

    @InjectMocks
    private VisitSDJpaService service;

    @Test
    void findAll() {
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());

        when(repository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();
        assertThat(foundVisits).isNotNull();
        assertTrue(visits.size() == 1);

        verify(repository).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();
        when(repository.findById(1L)).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        assertThat(foundVisit).isNotNull();
        verify(repository).findById(anyLong());
    }

    @Test
    void save() {
        service.save(new Visit());
        verify(repository).save(any(Visit.class));
    }

    @Test
    void delete() {
        service.delete(new Visit());
        verify(repository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository).deleteById(anyLong());
    }

}