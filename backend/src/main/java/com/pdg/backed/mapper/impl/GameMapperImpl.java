package com.pdg.backed.mapper.impl;

import org.springframework.stereotype.Controller;

import com.pdg.backed.domain.game.CreateGameRequest;
import com.pdg.backed.domain.game.UpdateGameRequest;
import com.pdg.backed.domain.game.dto.CreateGameRequestDto;
import com.pdg.backed.domain.game.dto.GameDto;
import com.pdg.backed.domain.game.dto.UpdateGameRequestDto;
import com.pdg.backed.domain.game.entity.Game;
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
    public UpdateGameRequest fromDto(UpdateGameRequestDto dto) {
        return new UpdateGameRequest(
            dto.title(),
            dto.imageUrl(),
            dto.description(),
            dto.release()
        );
    };

    @Override
    public GameDto toDto(Game game) {
        return new GameDto(
            game.getGameId(),
            game.getTitle(),
            game.getImageUrl(),
            game.getDescription(),
            game.getRelease(),
            game.getCreated(),
            game.getUpdated()
        );
    };
}