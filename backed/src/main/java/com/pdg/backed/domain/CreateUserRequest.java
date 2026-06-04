package com.pdg.backed.domain;

public record CreateUserRequest(String email, String password, String userName) {}
