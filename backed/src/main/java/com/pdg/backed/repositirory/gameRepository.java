package com.pdg.backed.repositirory;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdg.backed.domain.entity.Game;

@Repository
public interface gameRepository extends JpaRepository<Game,UUID> {}
