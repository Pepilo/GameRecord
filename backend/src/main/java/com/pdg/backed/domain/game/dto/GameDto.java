package com.pdg.backed.domain.game.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record GameDto(
    UUID gameId,
    Long rawgId,
    String slug,
    String title,
    String imageUrl,
    String description,
    LocalDate release,
    Boolean tba,
    Instant created,
    Instant updated
) {}