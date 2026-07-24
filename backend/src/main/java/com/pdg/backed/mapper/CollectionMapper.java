package com.pdg.backed.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.pdg.backed.domain.collection.CreateCollectionRequest;
import com.pdg.backed.domain.collection.UpdateCollectionRequest;
import com.pdg.backed.domain.collection.dto.CollectionDto;
import com.pdg.backed.domain.collection.dto.CreateCollectionRequestDto;
import com.pdg.backed.domain.collection.dto.UpdateCollectionRequestDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CollectionMapper {

    CreateCollectionRequest fromDto(CreateCollectionRequestDto dto);

    UpdateCollectionRequest fromDto(UpdateCollectionRequestDto dto);

    @Mapping(target = "author", source = "author")
    CollectionDto toDto(Collection collection);
}
