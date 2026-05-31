package com.pdg.backed.service.impl;

import org.springframework.stereotype.Service;

import com.pdg.backed.domain.CreateGameRequest;
import com.pdg.backed.domain.entity.Game;
import com.pdg.backed.repositirory.GameRepository;
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
}
