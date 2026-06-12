package com.pdg.backed.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCommentRequestDto(
    @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
    String content
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title must be between 1 and 255 characters.";
}
