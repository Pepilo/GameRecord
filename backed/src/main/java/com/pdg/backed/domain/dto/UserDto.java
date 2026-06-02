package com.pdg.backed.domain.dto;

import java.time.Instant;
import java.util.UUID;

public record UserDto(
    UUID userId,
    String email,
    String password,
    String userName,
    Instant created,
    Instant udpated
) {}