package com.plaxa.http.flight.validator;

import com.plaxa.http.flight.dto.CreateUserDto;
import com.plaxa.http.flight.entity.Gender;
import com.plaxa.http.flight.entity.Role;
import com.plaxa.http.flight.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (object.getName() == null) {
            validationResult.add(Error.of("invalid.name", "name is invalid"));
        }
        if (object.getEmail() == null) {
            validationResult.add(Error.of("invalid.email", "email is invalid"));
        }
        if (object.getPassword() == null) {
            validationResult.add(Error.of("invalid.password", "password is invalid"));
        }
        if (Gender.find(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "gender is invalid "));
        }
        if (Role.find(object.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "role is invalid"));
        }
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "birthday is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
