package com.pdg.backed.mapper.impl;

import org.springframework.stereotype.Controller;

import com.pdg.backed.domain.CreateGameRequest;
import com.pdg.backed.domain.dto.CreateGameRequestDto;
import com.pdg.backed.domain.dto.GameDto;
import com.pdg.backed.domain.entity.Game;
import com.pdg.backed.mapper.GameMapper;

@Controller
public class GameMapperImpl implements GameMapper {

    @Override
    public CreateGameRequest fromDto(CreateGameRequestDto dto) {
        return new CreateGameRequest(
            dto.title(),
            dto.imageUrl(),
            dto.description(),
            dto.release()
        );
    };

    @Override
    public GameDto toDto(Game game) {
        return new GameDto(
            game.getUuid(),
            game.getTitle(),
            game.getImageUrl(),
            game.getDescription(),
            game.getRelease(),
            game.getCreated(),
            game.getUpdated()
        );
    };

}
