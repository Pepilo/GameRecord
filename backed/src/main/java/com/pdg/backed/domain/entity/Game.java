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
    private UUID uuid;
    private String title;
    private String imageUrl;
    private String description;
    private LocalDate release;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public Game() {
    }

    public Game(String title, String imageUrl, String description, LocalDate release) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.release = release;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid= uuid;
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
        return Objects.equals(uuid, game.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public String toString() {
        return "Game{" + 
            "uuid =" + uuid +
            ", title =" + title + '\'' +
            ", imageUrl =" + imageUrl + '\'' +
            ", description =" + description + '\'' +
            ", release =" + release +
            ", created =" + created +
            ", updated =" + updated +
            '}';
    }
}
