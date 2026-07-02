package com.pdg.backed.domain.user;

public record CreateUserRequest(String email, String password, String userName) {}