package com.pdg.backed.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.dto.AuthResponse;
import com.pdg.backed.domain.dto.LoginRequest;
import com.pdg.backed.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        UserDetails userDetails = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        String tokenValue = authenticationService.generateToken(userDetails);

        AuthResponse authResponse = AuthResponse.builder()
            .token(tokenValue)
            .expiresIn(86400)
            .build();
        return ResponseEntity.ok(authResponse);
    }
}