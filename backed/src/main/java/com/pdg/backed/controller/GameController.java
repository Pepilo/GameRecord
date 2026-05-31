package com.pdg.backed.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.CreateGameRequest;
import com.pdg.backed.domain.dto.CreateGameRequestDto;
import com.pdg.backed.domain.dto.GameDto;
import com.pdg.backed.domain.entity.Game;
import com.pdg.backed.mapper.GameMapper;
import com.pdg.backed.service.GameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/games")
public class GameController {

    private final GameService gameService;
    private final GameMapper gameMapper;

    public GameController (GameService gameService, GameMapper gameMapper){
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }

    @PostMapping
    public ResponseEntity<GameDto> createGame(
        @Valid
        @RequestBody
        CreateGameRequestDto createGameRequestDto
    ) {
        CreateGameRequest createGameRequest = gameMapper.fromDto(createGameRequestDto);
        Game game = gameService.createGame(createGameRequest);
        GameDto createGameDto = gameMapper.toDto(game);
        return new ResponseEntity<>(createGameDto, HttpStatus.CREATED);
    }
}
