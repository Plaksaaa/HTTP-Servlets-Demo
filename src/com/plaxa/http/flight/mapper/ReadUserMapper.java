package com.plaxa.http.flight.mapper;

import com.plaxa.http.flight.dto.ReadUserDto;
import com.plaxa.http.flight.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ReadUserMapper implements Mapper<User, ReadUserDto> {

    private static final ReadUserMapper INSTANCE = new ReadUserMapper();

    @Override
    public ReadUserDto mapFrom(User object) {
        return ReadUserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static ReadUserMapper getInstance() {
        return INSTANCE;
    }
}
