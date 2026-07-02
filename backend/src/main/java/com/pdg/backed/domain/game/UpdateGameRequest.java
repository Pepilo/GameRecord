package com.pdg.backed.domain.game;

import java.time.LocalDate;

public record UpdateGameRequest(String title, String imageUrl, String description, LocalDate release) {}