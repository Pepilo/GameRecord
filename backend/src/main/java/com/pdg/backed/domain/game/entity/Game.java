package com.pdg.backed.domain.game.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "games")
@NoArgsConstructor
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gameId;
    @Column(unique = true, nullable = false)
    private Long rawgId;
    @Column(unique = true, nullable = false)
    private String slug;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String imageUrl;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDate released;
    @Column(nullable = false)
    private Boolean tba = false;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public Game(Long rawgId, String slug, String title, String imageUrl, String description, LocalDate release, Boolean tba) {
        this.rawgId = rawgId;
        this.slug = slug;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.released = release;
        this.tba = tba;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game other)) return false;

        return gameId != null && gameId.equals(other.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(gameId);
    }

    @Override
    public String toString() {
        return "Game{" + 
            "gameId =" + gameId +
            ", rawgId =" + rawgId +
            ", slug =" + slug + '\'' +
            ", title =" + title + '\'' +
            ", imageUrl =" + imageUrl + '\'' +
            ", description =" + description + '\'' +
            ", release =" + released +
            ", tba =" + tba +
            ", created =" + created +
            ", updated =" + updated +
            '}';
    }
}