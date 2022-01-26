
package com.n11.application.application.validation;

import com.n11.application.interfaces.ErrorCode;
import com.n11.application.interfaces.request.ModifyApplicationRequestDto;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ModifyApplicationRequestValidationService implements ValidationService<ModifyApplicationRequestDto> {
    @Override
    public ValidationResult validate(ModifyApplicationRequestDto request) {

        if (StringUtils.isBlank(request.getTckn()) || request.getTckn().length() != 11) {
            return ValidationResult.error("TCKN is not acceptable.", ErrorCode.TCKNISNOTVALID);
        }
        if (StringUtils.isBlank(request.getBirthdate())) {
            return ValidationResult.error("Birthdate is not acceptable.", ErrorCode.BIRTHDATEISNOTVALID);
        }

        return ValidationResult.success();
    }
}
