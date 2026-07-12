package com.pdg.backed.service;

import java.util.List;

import com.pdg.backed.domain.rawgGame.dto.RawgGameDto;

public interface RawgService {

    List<RawgGameDto> getRawgGames();
}