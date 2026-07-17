package com.pdg.backed.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.pdg.backed.domain.rawgGame.dto.RawgGamesResponseDto;

@Component
public class RawgClient {

    private final RestClient restClient;
    private final String apiKey;

    public RawgClient(RestClient.Builder builder, @Value("${rawg.api.key}") String apiKey) {
        this.restClient = builder
                .baseUrl("https://api.rawg.io/api")
                .build();
        this.apiKey = apiKey;
    }

    public RawgGamesResponseDto getRawgGames(int page) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/games")
                    .queryParam("key", apiKey)
                    .queryParam("page_size", 20)
                    .queryParam("page", page)
                    .build())
                .retrieve()
                .body(RawgGamesResponseDto.class);
    }
}