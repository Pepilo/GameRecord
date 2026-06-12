package com.pdg.backed.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdg.backed.domain.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {}