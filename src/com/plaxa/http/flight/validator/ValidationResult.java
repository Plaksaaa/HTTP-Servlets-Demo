package com.plaxa.http.flight.validator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    @Getter
    private final List<Error> errors = new ArrayList<>();

    public void add(Error error) {
        this.errors.add(error);
    }

    //    if list is empty - validation result is valid and we can go on processing
    public boolean isValid() {
        return errors.isEmpty();
    }
}
