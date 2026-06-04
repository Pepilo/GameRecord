package com.pdg.backed.mapper;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.dto.CreateUserRequestDto;
import com.pdg.backed.domain.dto.UserDto;
import com.pdg.backed.domain.entity.User;

public interface UserMapper {

    CreateUserRequest fromDto(CreateUserRequestDto dto);

    UserDto toDto(User user);
}