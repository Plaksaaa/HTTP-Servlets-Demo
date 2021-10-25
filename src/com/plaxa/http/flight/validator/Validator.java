package com.plaxa.http.flight.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
