package com.pdg.backed.service;

import java.util.List;

import com.pdg.backed.domain.game.entity.Game;

public interface GameService {

    List<Game> getGames();
}