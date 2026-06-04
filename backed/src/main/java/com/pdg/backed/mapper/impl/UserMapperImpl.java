package com.pdg.backed.mapper.impl;

import org.springframework.stereotype.Controller;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.dto.CreateUserRequestDto;
import com.pdg.backed.domain.dto.UserDto;
import com.pdg.backed.domain.entity.User;
import com.pdg.backed.mapper.UserMapper;

@Controller
public class UserMapperImpl implements UserMapper {

    @Override
    public CreateUserRequest fromDto(CreateUserRequestDto dto) {
        return new CreateUserRequest(
            dto.email(),
            dto.password(),
            dto.userName()
        );
    };

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
            user.getUserId(),
            user.getEmail(),
            user.getPassword(),
            user.getUserName(),
            user.getCreated(),
            user.getUpdated()
        );
    };
}
