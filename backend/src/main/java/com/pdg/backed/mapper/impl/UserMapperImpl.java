package com.pdg.backed.mapper.impl;

import org.springframework.stereotype.Controller;

import com.pdg.backed.domain.user.CreateUserRequest;
import com.pdg.backed.domain.user.UpdateUserRequest;
import com.pdg.backed.domain.user.dto.CreateUserRequestDto;
import com.pdg.backed.domain.user.dto.UpdateUserRequestDto;
import com.pdg.backed.domain.user.dto.UserDto;
import com.pdg.backed.domain.user.entity.User;
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
    public UpdateUserRequest fromDto(UpdateUserRequestDto dto) {
        return new UpdateUserRequest(
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
            user.getUserName(),
            user.getCreated(),
            user.getUpdated()
        );
    };
}
