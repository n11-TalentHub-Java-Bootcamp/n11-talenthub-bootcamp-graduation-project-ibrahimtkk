package com.n11.application.application.validation;

import com.n11.application.interfaces.ErrorCode;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class CreateApplicationValidationService {

    ApplicationRequestValidationService validationService = new ApplicationRequestValidationService();

    @Test
    public void validateShouldReturnTCKNNotValidErrorWhenGivenTCKNIsNull() {

        final ApplicationRequestDto request = new ApplicationRequestDto();
        final ValidationResult result = validationService.validate(request);

        assertThat(result.getIsValid(), is(Boolean.FALSE));
        assertThat(result.getMessage(), is("TCKN is not acceptable."));
        assertThat(result.getErrorCode(), is(ErrorCode.TCKNISNOTVALID));
    }

    @Test
    public void validateShouldReturnBirthdateNotValidErrorWhenGivenBirthdateIsNull() {

        final ApplicationRequestDto request = new ApplicationRequestDto();
        request.setTckn("11223334455");
        final ValidationResult result = validationService.validate(request);

        assertThat(result.getIsValid(), is(Boolean.FALSE));
        assertThat(result.getMessage(), is("Birthdate is not acceptable."));
        assertThat(result.getErrorCode(), is(ErrorCode.BIRTHDATEISNOTVALID));
    }

    @Test
    public void validateShouldReturnNameNotValidErrorWhenGivenNameIsNull() {

        final ApplicationRequestDto request = new ApplicationRequestDto();
        request.setTckn("11223334455");
        request.setBirthdate("2022-11-21");
        final ValidationResult result = validationService.validate(request);

        assertThat(result.getIsValid(), is(Boolean.FALSE));
        assertThat(result.getMessage(), is("Name is not acceptable."));
        assertThat(result.getErrorCode(), is(ErrorCode.NAMEISNOTVALID));
    }

    @Test
    public void validateShouldReturnSurnameNotValidErrorWhenGivenSurnameIsNull() {

        final ApplicationRequestDto request = new ApplicationRequestDto();
        request.setTckn("11223334455");
        request.setBirthdate("2022-11-21");
        request.setName("ibrahim");
        final ValidationResult result = validationService.validate(request);

        assertThat(result.getIsValid(), is(Boolean.FALSE));
        assertThat(result.getMessage(), is("Surname is not acceptable."));
        assertThat(result.getErrorCode(), is(ErrorCode.SURNAMEISNOTVALID));
    }

    @Test
    public void validateShouldReturnPhoneNotValidErrorWhenGivenPhoneIsNull() {

        final ApplicationRequestDto request = new ApplicationRequestDto();
        request.setTckn("11223334455");
        request.setBirthdate("2022-11-21");
        request.setName("ibrahim");
        request.setSurname("miharbi");
        final ValidationResult result = validationService.validate(request);

        assertThat(result.getIsValid(), is(Boolean.FALSE));
        assertThat(result.getMessage(), is("Phone is not acceptable."));
        assertThat(result.getErrorCode(), is(ErrorCode.PHONEISNOTVALID));
    }



}
