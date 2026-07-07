package com.pdg.backed.domain.user.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequestDto(
    @NotBlank(message = "Email must be provided.")
    @Email(message = "Email must be valid.")
    String email,
    @NotBlank(message = ERROR_MESSAGE_PASSWORD_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_PASSWORD_LENGTH)
    String password,
    @NotBlank(message = ERROR_MESSAGE_USERNAME_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_USERNAME_LENGTH)
    String userName
) {
    private static final String ERROR_MESSAGE_PASSWORD_LENGTH = "Password must be between 1 and 255 characters.";
    private static final String ERROR_MESSAGE_USERNAME_LENGTH = "User name must be between 1 and 255 characters.";
}