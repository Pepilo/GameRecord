package com.pdg.backed.service;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.entity.User;

public interface UserService {

    User createUser(CreateUserRequest request);
}
