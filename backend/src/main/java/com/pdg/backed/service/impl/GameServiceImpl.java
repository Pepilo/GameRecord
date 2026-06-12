package com.pdg.backed.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.CreateGameRequest;
import com.pdg.backed.domain.UpdateGameRequest;
import com.pdg.backed.domain.entity.Game;
import com.pdg.backed.exception.NotFoundException;
import com.pdg.backed.repository.GameRepository;
import com.pdg.backed.service.GameService;

@Service
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(CreateGameRequest request) {
        Game game = new Game(
            request.title(),
            request.imageUrl(),
            request.description(),
            request.release()
        );

        return gameRepository.save(game);
    }

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    @Override
    public Game updateGame(UUID gameId, UpdateGameRequest request) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NotFoundException(gameId));

        game.setTitle(request.title());
        game.setImageUrl(request.imageUrl());
        game.setDescription(request.description());
        game.setRelease(request.release());

        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(UUID gameId) {
        gameRepository.deleteById(gameId);
    }
}