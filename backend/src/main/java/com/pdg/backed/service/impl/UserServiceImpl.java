package com.pdg.backed.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.CreateUserRequest;
import com.pdg.backed.domain.UpdateUserRequest;
import com.pdg.backed.domain.entity.Game;
import com.pdg.backed.domain.entity.User;
import com.pdg.backed.exception.NotFoundException;
import com.pdg.backed.repository.UserRepository;
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

    @Override
    public List<User> getUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "userName"));
    }

    @Override
    public User updateUser(UUID userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId));

        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setUserName(request.userName());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}