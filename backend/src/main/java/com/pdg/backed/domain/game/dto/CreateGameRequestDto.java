package com.pdg.backed.domain.game.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateGameRequestDto(
    @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
    String title,
    @NotBlank(message = ERROR_MESSAGE_IMAGEURL_LENGTH)
    @Length(max = 255, message = ERROR_MESSAGE_IMAGEURL_LENGTH)
    String imageUrl,
    String description,
    @NotNull(message = ERROR_MESSAGE_RELEASE)
    LocalDate release) {

    private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title must be between 1 and 255 characters.";
    private static final String ERROR_MESSAGE_IMAGEURL_LENGTH = "Image URL must be between 1 and 255 characters.";
    private static final String ERROR_MESSAGE_RELEASE = "Release date must be provided.";
}