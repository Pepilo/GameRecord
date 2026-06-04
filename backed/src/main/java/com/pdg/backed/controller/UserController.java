package com.pdg.backed.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.dto.CreateUserRequestDto;
import com.pdg.backed.domain.dto.UserDto;
import com.pdg.backed.domain.entity.User;
import com.pdg.backed.mapper.UserMapper;
import com.pdg.backed.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController (UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
        @Valid
        @RequestBody
        CreateUserRequestDto createUserRequestDto
    ) {
        CreateUserRequest createUserRequest = userMapper.fromDto(createUserRequestDto);
        User user = userService.createUser(createUserRequest);
        UserDto createUserDto = userMapper.toDto(user);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
}