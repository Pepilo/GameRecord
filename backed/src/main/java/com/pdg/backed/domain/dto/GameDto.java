package com.pdg.backed.domain.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import com.pdg.backed.domain.entity.GameStatus;

public record GameDto(
    UUID uuid,
    String title,
    String imageUrl,
    String description,
    LocalDate release,
    GameStatus status,
    Instant created,
    Instant updated
) {}