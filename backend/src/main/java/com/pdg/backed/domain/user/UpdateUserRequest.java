package com.pdg.backed.domain.user;

public record UpdateUserRequest(String email, String password, String userName) {}