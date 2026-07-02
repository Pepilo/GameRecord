package com.pdg.backed.domain.review.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record CreateReviewRequestDto (
    @Length(max = 255, message = "Title must be between 1 and 255 characters.")
    String title,
    @NotBlank(message = "Content must be provided.")
    @Length(max = 50000, message = "Content must be under 50000 characters.")
    String content
) {}