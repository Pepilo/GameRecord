package com.pdg.backed.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.game.CreateGameRequest;
import com.pdg.backed.domain.game.UpdateGameRequest;
import com.pdg.backed.domain.game.dto.CreateGameRequestDto;
import com.pdg.backed.domain.game.dto.GameDto;
import com.pdg.backed.domain.game.dto.UpdateGameRequestDto;
import com.pdg.backed.domain.game.entity.Game;
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

    @GetMapping
    public ResponseEntity<List<GameDto>> getGames() {
        List<Game> games = gameService.getGames();
        List<GameDto> gameDtos = games.stream().map(gameMapper::toDto).toList();
        return ResponseEntity.ok(gameDtos);
    }

    @PutMapping(path = "/{gameId}")
    public ResponseEntity<GameDto> updateGame(
        @PathVariable UUID gameId,
        @Valid
        @RequestBody
        UpdateGameRequestDto updateGameRequestDto
    ) {
        UpdateGameRequest updateGameRequest = gameMapper.fromDto(updateGameRequestDto);
        Game game = gameService.updateGame(gameId, updateGameRequest);
        GameDto GameDto = gameMapper.toDto(game);
        return ResponseEntity.ok(GameDto);
    }

    @DeleteMapping(path = "/{gameId}")
    public ResponseEntity<Void> deleteGame(
        @PathVariable UUID gameId
    ) {
        gameService.deleteGame(gameId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}