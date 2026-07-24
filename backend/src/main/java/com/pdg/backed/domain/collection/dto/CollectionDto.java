package com.pdg.backed.domain.collection.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.pdg.backed.domain.dto.AuthorDto;
import com.pdg.backed.domain.game.entity.Game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollectionDto {

    private UUID collectionId;
    private String title;
    private List<Game> content;
    private AuthorDto author;
    private Instant created;
    private Instant updated;
}