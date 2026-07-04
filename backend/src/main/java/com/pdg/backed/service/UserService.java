package com.pdg.backed.service;

import java.util.List;
import java.util.UUID;

import com.pdg.backed.domain.user.CreateUserRequest;
import com.pdg.backed.domain.user.UpdateUserRequest;
import com.pdg.backed.domain.user.entity.User;

public interface UserService {

    User createUser(CreateUserRequest request);

    User getUserById(UUID userId);

    List<User> getUsers();

    User updateUser(UUID userId, UpdateUserRequest request);

    void deleteUser(UUID userId);
}