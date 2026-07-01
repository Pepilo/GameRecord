package com.pdg.backed.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.UpdateUserRequest;
import com.pdg.backed.domain.dto.CreateUserRequestDto;
import com.pdg.backed.domain.dto.UpdateUserRequestDto;
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

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();
        List<UserDto> userDtos = users.stream().map(userMapper::toDto).toList();
        return ResponseEntity.ok(userDtos);
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserDto> updateUser(
        @PathVariable UUID userId,
        @Valid
        @RequestBody
        UpdateUserRequestDto updateGameRequestDto
    ) {
        UpdateUserRequest updateUserRequest = userMapper.fromDto(updateGameRequestDto);
        User user = userService.updateUser(userId, updateUserRequest);
        UserDto userDto = userMapper.toDto(user);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(
        @PathVariable UUID userId
    ) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}