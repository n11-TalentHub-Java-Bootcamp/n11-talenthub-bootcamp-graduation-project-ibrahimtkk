package com.n11.application.application.validation;

import com.n11.application.interfaces.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResult {
    private Boolean isValid;
    private String message;
    private ErrorCode errorCode;

    private ValidationResult(Boolean isValid, String message, ErrorCode errorCode) {
        this(isValid);
        this.message = message;
        this.errorCode = errorCode;
    }

    private ValidationResult(Boolean isValid) {
        this.isValid = isValid;
    }

    public static ValidationResult error(String message, ErrorCode errorCode) {
        return new ValidationResult(Boolean.FALSE, message, errorCode);
    }

    public static ValidationResult success() {
        return new ValidationResult(Boolean.TRUE);
    }
}