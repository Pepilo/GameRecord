package com.pdg.backed.mapper;

import com.pdg.backed.domain.user.CreateUserRequest;
import com.pdg.backed.domain.user.UpdateUserRequest;
import com.pdg.backed.domain.user.dto.CreateUserRequestDto;
import com.pdg.backed.domain.user.dto.UpdateUserRequestDto;
import com.pdg.backed.domain.user.dto.UserDto;
import com.pdg.backed.domain.user.entity.User;

public interface UserMapper {

    CreateUserRequest fromDto(CreateUserRequestDto dto);

    UpdateUserRequest fromDto(UpdateUserRequestDto dto);

    UserDto toDto(User user);
}