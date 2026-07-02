package com.pdg.backed.domain.review.dto;

import java.time.Instant;
import java.util.UUID;

import com.pdg.backed.domain.dto.AuthorDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private UUID reviewId;
    private String title;
    private String content;
    private AuthorDto author;
    private Instant created;
    private Instant updated;
}
