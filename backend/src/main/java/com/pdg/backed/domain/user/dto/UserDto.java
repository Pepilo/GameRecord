package com.pdg.backed.domain.user.dto;

import java.time.Instant;
import java.util.UUID;

public record UserDto(
    UUID userId,
    String email,
    String userName,
    Instant created,
    Instant udpated
) {}