package com.pdg.backed.mapper;

import com.pdg.backed.domain.game.CreateGameRequest;
import com.pdg.backed.domain.game.UpdateGameRequest;
import com.pdg.backed.domain.game.dto.CreateGameRequestDto;
import com.pdg.backed.domain.game.dto.GameDto;
import com.pdg.backed.domain.game.dto.UpdateGameRequestDto;
import com.pdg.backed.domain.game.entity.Game;

public interface GameMapper {

    CreateGameRequest fromDto(CreateGameRequestDto dto);

    UpdateGameRequest fromDto(UpdateGameRequestDto dto);

    GameDto toDto(Game game);
}