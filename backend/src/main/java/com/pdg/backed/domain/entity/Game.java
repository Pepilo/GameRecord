package com.pdg.backed.domain.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @UuidGenerator
    private UUID gameId;
    private String title;
    private String imageUrl;
    private String description;
    private LocalDate release;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public Game() {}

    public Game(String title, String imageUrl, String description, LocalDate release) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.release = release;
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Game game = (Game) o;
        return Objects.equals(gameId, game.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(gameId);
    }

    @Override
    public String toString() {
        return "Game{" + 
            "gameId =" + gameId +
            ", title =" + title + '\'' +
            ", imageUrl =" + imageUrl + '\'' +
            ", description =" + description + '\'' +
            ", release =" + release +
            ", created =" + created +
            ", updated =" + updated +
            '}';
    }
}