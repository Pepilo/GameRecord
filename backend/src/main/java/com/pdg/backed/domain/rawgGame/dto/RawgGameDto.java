package com.pdg.backed.domain.rawgGame.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RawgGameDto(
    @JsonProperty("id")
    Long rawgId,
    String slug,
    @JsonProperty("name")
    String title,
    @JsonProperty("background_image")
    String imageUrl,
    String description,
    LocalDate released,
    Boolean tba
) {}