package com.pdg.backed.domain.rawgGame.dto;

import java.util.List;

public record RawgGamesResponseDto(

    Integer count,
    String next,
    String previous,
    List<RawgGameDto> results
) {}