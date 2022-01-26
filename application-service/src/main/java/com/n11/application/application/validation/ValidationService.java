package com.n11.application.application.validation;

public interface ValidationService<T> {

    ValidationResult validate(T request);
}
