package com.pdg.backed.controller;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.collection.CreateCollectionRequest;
import com.pdg.backed.domain.collection.UpdateCollectionRequest;
import com.pdg.backed.domain.collection.dto.CollectionDto;
import com.pdg.backed.domain.collection.dto.CreateCollectionRequestDto;
import com.pdg.backed.domain.collection.dto.UpdateCollectionRequestDto;
import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.UpdateReviewRequest;
import com.pdg.backed.domain.review.dto.CreateReviewRequestDto;
import com.pdg.backed.domain.review.dto.ReviewDto;
import com.pdg.backed.domain.review.dto.UpdateReviewRequestDto;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.domain.user.entity.User;
import com.pdg.backed.mapper.CollectionMapper;
import com.pdg.backed.mapper.ReviewMapper;
import com.pdg.backed.service.CollectionService;
import com.pdg.backed.service.ReviewService;
import com.pdg.backed.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/collections")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;
    private final UserService userService;
    private final CollectionMapper collectionMapper;

    @PostMapping
    public ResponseEntity<CollectionDto> createCollection(
        @Valid
        @RequestBody CreateCollectionRequestDto createCollectionRequestDto,
        @RequestAttribute UUID userId
    ) {
        User loggedInUser = userService.getUserById(userId);
        CreateCollectionRequest createCollectionRequest = collectionMapper.fromDto(createCollectionRequestDto);
        Collection collection = collectionService.createCollection(loggedInUser, createCollectionRequest);
        CollectionDto createCollectionDto = collectionMapper.toDto(collection);
        return new ResponseEntity<>(createCollectionDto, HttpStatus.CREATED);
        
    }

    @GetMapping
    public ResponseEntity<List<CollectionDto>> getCollections() {
        List<Collection> collections = collectionService.getCollections();
        List<CollectionDto> collectionDtos = collections.stream().map(collectionMapper::toDto).toList();
        return ResponseEntity.ok(collectionDtos);
    }

    @PutMapping(path = "/{collectionId}")
    public ResponseEntity<CollectionDto> updateCollection(
        @PathVariable UUID collectionId,
        @Valid
        @RequestBody UpdateCollectionRequestDto updateCollectionRequestDto
    ) {
        UpdateCollectionRequest updateCollectionRequest = collectionMapper.fromDto(updateCollectionRequestDto);
        Collection collection = collectionService.updateCollection(collectionId, updateCollectionRequest);
        CollectionDto collectionDto = collectionMapper.toDto(collection);
        return ResponseEntity.ok(collectionDto);
    }

    @DeleteMapping(path = "/{collectionId}")
    public ResponseEntity<Void> deleteCollection(
        @PathVariable UUID collectionId
    ) {
        collectionService.deleteCollection(collectionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}