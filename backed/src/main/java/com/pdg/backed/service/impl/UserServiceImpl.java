package com.pdg.backed.service.impl;

import org.springframework.stereotype.Service;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.entity.User;
import com.pdg.backed.repositirory.UserRepository;
import com.pdg.backed.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User(
            request.email(),
            request.password(),
            request.userName()
        );

        return userRepository.save(user);
    }
}