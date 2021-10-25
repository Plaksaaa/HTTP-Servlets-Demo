package com.plaxa.http.flight.service;

import com.plaxa.http.flight.dao.UserDao;
import com.plaxa.http.flight.dto.CreateUserDto;
import com.plaxa.http.flight.dto.ReadUserDto;
import com.plaxa.http.flight.exception.ValidationException;
import com.plaxa.http.flight.mapper.CreateUserMapper;
import com.plaxa.http.flight.mapper.ReadUserMapper;
import com.plaxa.http.flight.validator.CreateUserValidator;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final ReadUserMapper readUserMapper = ReadUserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    private static class UserServiceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    public Optional<ReadUserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(readUserMapper::mapFrom);
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
//        validate userDto
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        //        map
        var userEntity = createUserMapper.mapFrom(userDto);
        //        userDao.save
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);
        //        return id
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return UserServiceHolder.INSTANCE;
    }

}
