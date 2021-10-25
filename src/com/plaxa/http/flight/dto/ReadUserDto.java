package com.plaxa.http.flight.dto;

import com.plaxa.http.flight.entity.Gender;
import com.plaxa.http.flight.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ReadUserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    String image;
    Gender gender;
    Role role;
}
