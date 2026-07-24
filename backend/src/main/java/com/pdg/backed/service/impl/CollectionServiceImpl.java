package com.pdg.backed.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pdg.backed.domain.collection.CreateCollectionRequest;
import com.pdg.backed.domain.collection.dto.UpdateCollectionRequestDto;
import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.UpdateReviewRequest;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.domain.user.entity.User;
import com.pdg.backed.repository.CollectionRepository;
import com.pdg.backed.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl {

    private final CollectionRepository collectionRepository;

    @Override
    public Collection createCollection(User user, CreateCollectionRequest request) {
        Collection collection = new Collection(
            request.title(),
            request.content(),
            user
        );

        return collectionRepository.save(collection);
    }

    @Override
    public List<Collection> getCollections() {
        return collectionRepository.findAll(Sort.by(Sort.Direction.ASC, "collectionId"));
    }

    @Override
    public Collection updateCollection(UUID collectionId, UpdateCollectionRequest request) {
        Collection collection = collectionRepository.findById(collectionId).orElseThrow(() -> new NotFoundException(collectionId));

        collection.setTitle(request.title());
        collection.setContent(request.content());

        return collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(UUID collectionId) {
        collectionRepository.deleteById(collectionId);
    }
}