package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_1 = "redirect:/owners/1";

    @Mock
    private OwnerService ownerService;

    @Mock
    private BindingResult result;

    @InjectMocks
    private OwnerController ownerController;

    @Test
    void processCreationFormHasErrors() {
        // Given
        Owner owner = new Owner(1L, "Joe", "Buck");
        given(result.hasErrors()).willReturn(true);

        // When
        String view = ownerController.processCreationForm(owner, result);

        // Then
        assertThat(view).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
    }

    @Test
    void processCreationFormNoErrors() {
        // Given
        Owner owner = new Owner(1L, "Joe", "Buck");
        given(result.hasErrors()).willReturn(false);
        given(ownerService.save(any(Owner.class))).willReturn(owner);

        // When
        String view = ownerController.processCreationForm(owner, result);

        // Then
        assertThat(view).isEqualToIgnoringCase(REDIRECT_OWNERS_1);
        then(ownerService).should().save(any(Owner.class));
    }

}