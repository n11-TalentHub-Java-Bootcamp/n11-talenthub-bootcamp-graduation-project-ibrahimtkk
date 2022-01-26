
package com.n11.application.application.validation;

import com.n11.application.interfaces.ErrorCode;
import com.n11.application.interfaces.request.ApplicationRequestDto;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ApplicationRequestValidationService implements ValidationService<ApplicationRequestDto> {
    @Override
    public ValidationResult validate(ApplicationRequestDto request) {

        if (StringUtils.isBlank(request.getTckn()) || request.getTckn().length() != 11) {
            return ValidationResult.error("TCKN is not acceptable.", ErrorCode.TCKNISNOTVALID);
        }
        if (StringUtils.isBlank(request.getBirthdate())) {
            return ValidationResult.error("Birthdate is not acceptable.", ErrorCode.BIRTHDATEISNOTVALID);
        }
        if (StringUtils.isBlank(request.getName())) {
            return ValidationResult.error("Name is not acceptable.", ErrorCode.NAMEISNOTVALID);
        }
        if (StringUtils.isBlank(request.getSurname())) {
            return ValidationResult.error("Surname is not acceptable.", ErrorCode.SURNAMEISNOTVALID);
        }
        if (StringUtils.isBlank(request.getPhone())) {
            return ValidationResult.error("Phone is not acceptable.", ErrorCode.PHONEISNOTVALID);
        }


        return ValidationResult.success();
    }
}
