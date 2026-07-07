package com.pdg.backed.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.user.CreateUserRequest;
import com.pdg.backed.domain.user.UpdateUserRequest;
import com.pdg.backed.domain.user.entity.User;
import com.pdg.backed.exception.NotFoundException;
import com.pdg.backed.repository.UserRepository;
import com.pdg.backed.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User(
            request.email(),
            passwordEncoder.encode(request.password()),
            request.userName()
        );

        return userRepository.save(user);
    }

    @Override
    public User getUserById(UUID userId)
    {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "userName"));
    }

    @Override
    public User updateUser(UUID userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId));

        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setUserName(request.userName());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}