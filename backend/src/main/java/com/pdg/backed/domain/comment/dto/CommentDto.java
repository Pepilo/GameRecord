package com.pdg.backed.domain.comment.dto;

import java.time.Instant;
import java.util.UUID;

public record CommentDto(
    UUID gameId,
    String content,
    Instant created,
    Instant updated
) {}