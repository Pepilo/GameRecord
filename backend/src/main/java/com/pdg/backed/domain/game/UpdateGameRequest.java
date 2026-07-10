package com.pdg.backed.domain.game;

import java.time.LocalDate;

public record UpdateGameRequest(Long rawgId, String slug, String title, String imageUrl, String description, LocalDate release, Boolean tba) {}