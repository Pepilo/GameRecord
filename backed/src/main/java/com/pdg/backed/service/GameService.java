package com.pdg.backed.service;

import com.pdg.backed.domain.CreateGameRequest;
import com.pdg.backed.domain.entity.Game;

public interface GameService {

    Game createGame(CreateGameRequest request);
}
