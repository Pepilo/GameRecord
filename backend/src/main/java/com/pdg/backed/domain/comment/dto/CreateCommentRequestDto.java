package com.pdg.backed.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCommentRequestDto(
    @NotBlank(message = ERROR_MESSAGE_CONTENT_LENGTH)
    String content
) {
    private static final String ERROR_MESSAGE_CONTENT_LENGTH = "Content must be provided.";
}
