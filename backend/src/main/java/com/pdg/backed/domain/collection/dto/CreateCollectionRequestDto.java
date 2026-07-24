package com.pdg.backed.domain.collection.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.pdg.backed.domain.game.entity.Game;

public record CreateCollectionRequestDto(
    @Length(max = 255, message = "Title must be between 1 and 255 characters.")
    String title,
    List<Game> content
) {}