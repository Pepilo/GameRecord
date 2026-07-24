package com.pdg.backed.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.pdg.backed.domain.collection.CreateCollectionRequest;
import com.pdg.backed.domain.collection.dto.UpdateCollectionRequestDto;
import com.pdg.backed.domain.user.entity.User;

public interface CollectionService {

    Collection createCollection(User user, CreateCollectionRequest request);

    List<Collection> getCollections();

    Collection updateCollection(UUID collectionId, UpdateCollectionRequestDto request);

    void deleteCollection(UUID collectionId);
}