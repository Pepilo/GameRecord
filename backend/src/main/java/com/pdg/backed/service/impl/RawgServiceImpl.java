package com.pdg.backed.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pdg.backed.client.RawgClient;
import com.pdg.backed.domain.rawgGame.dto.RawgGamesResponseDto;
import com.pdg.backed.service.RawgService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RawgServiceImpl implements RawgService {

    private final RawgClient rawgClient;

    @Override
    public RawgGamesResponseDto getRawgGames(int page) {
        return rawgClient.getRawgGames(page);
    }
}