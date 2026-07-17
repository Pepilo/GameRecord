package com.pdg.backed.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.rawgGame.dto.RawgGamesResponseDto;
import com.pdg.backed.service.RawgService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/rawgGames")
@RequiredArgsConstructor
public class RawgGameController {

    private final RawgService rawgService;

    @GetMapping()
    public ResponseEntity<RawgGamesResponseDto> getRawgGames(
        @RequestParam(defaultValue = "1") int page
    ) {
        return ResponseEntity.ok(rawgService.getRawgGames(page));
    }
}