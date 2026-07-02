package com.pdg.backed.service;

import java.util.List;
import java.util.UUID;

import com.pdg.backed.domain.game.CreateGameRequest;
import com.pdg.backed.domain.game.UpdateGameRequest;
import com.pdg.backed.domain.game.entity.Game;

public interface GameService {

    Game createGame(CreateGameRequest request);

    List<Game> getGames();

    Game updateGame(UUID gameId, UpdateGameRequest request);

    void deleteGame(UUID gameId);
}