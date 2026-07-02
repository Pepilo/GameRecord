package com.pdg.backed.domain.game.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record GameDto(
    UUID gameId,
    String title,
    String imageUrl,
    String description,
    LocalDate release,
    Instant created,
    Instant updated
) {}