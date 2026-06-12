package com.pdg.backed.domain.dto;

import java.time.Instant;
import java.util.UUID;

public record CommentDto(
    UUID gameId,
    String content,
    Instant created,
    Instant updated
) {}