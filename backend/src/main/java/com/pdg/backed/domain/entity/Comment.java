package com.pdg.backed.domain.entity;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @UuidGenerator
    private UUID commentId;
    private String content;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public Comment() {}

    public Comment(String content) {
        this.content = content;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(commentId);
    }

    @Override
    public String toString() {
        return "Comment{" + 
            "commentId =" + commentId +
            ", content =" + content + '\'' +
            ", created =" + created +
            ", updated =" + updated +
            '}';
    }
}