package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    @Test
    void processCreationForm() {
        // Given
        Owner owner = new Owner(1L, "Joe", "Buck");
        BindingResult result;
        given(ownerService.save(any(Owner.class))).willReturn(any(Owner.class));

        // When
        String view = ownerController.processCreationForm(owner, result);

        // Then
        assertThat(view).isEqualTo("redirect:/owners/" + owner.getId());
        then(ownerService).should().save(any(Owner.class));

    }
}