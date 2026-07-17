package com.pdg.backed.service;

import com.pdg.backed.domain.rawgGame.dto.RawgGamesResponseDto;

public interface RawgService {

    RawgGamesResponseDto getRawgGames(int page);
}