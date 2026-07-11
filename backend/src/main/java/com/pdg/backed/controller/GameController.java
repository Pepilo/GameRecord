package com.pdg.backed.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.game.dto.GameDto;
import com.pdg.backed.domain.game.entity.Game;
import com.pdg.backed.mapper.GameMapper;
import com.pdg.backed.service.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final GameMapper gameMapper;

    @GetMapping
    public ResponseEntity<List<GameDto>> getGames() {
        List<Game> games = gameService.getGames();
        List<GameDto> gameDtos = games.stream().map(gameMapper::toDto).toList();
        return ResponseEntity.ok(gameDtos);
    }
}