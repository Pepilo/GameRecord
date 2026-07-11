package com.pdg.backed.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.game.entity.Game;
import com.pdg.backed.repository.GameRepository;
import com.pdg.backed.service.GameService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }
}