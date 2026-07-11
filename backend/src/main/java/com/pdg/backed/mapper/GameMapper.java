package com.pdg.backed.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pdg.backed.domain.game.dto.GameDto;
import com.pdg.backed.domain.game.entity.Game;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GameMapper {

    GameDto toDto(Game game);
}