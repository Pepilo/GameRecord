package com.pdg.backed.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdg.backed.domain.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {}