package com.pdg.backed.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.UpdateReviewRequest;
import com.pdg.backed.domain.review.dto.CreateReviewRequestDto;
import com.pdg.backed.domain.review.dto.ReviewDto;
import com.pdg.backed.domain.review.dto.UpdateReviewRequestDto;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.domain.user.dto.UserDto;
import com.pdg.backed.domain.user.entity.User;
import com.pdg.backed.mapper.ReviewMapper;
import com.pdg.backed.service.ReviewService;
import com.pdg.backed.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(
        @Valid
        @RequestBody CreateReviewRequestDto createReviewRequestDto,
        @RequestAttribute UUID userId
    ) {
        User loggedInUser = userService.getUserById(userId);
        CreateReviewRequest createReviewRequest = reviewMapper.fromDto(createReviewRequestDto);
        Review review = reviewService.createReview(loggedInUser, createReviewRequest);
        ReviewDto createReviewDto = reviewMapper.toDto(review);
        return new ResponseEntity<>(createReviewDto, HttpStatus.CREATED);
        
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        List<ReviewDto> reviewDtos = reviews.stream().map(reviewMapper::toDto).toList();
        return ResponseEntity.ok(reviewDtos);
    }

    @PutMapping(path = "/{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(
        @PathVariable UUID reviewId,
        @Valid
        @RequestBody UpdateReviewRequestDto uReviewRequestDto
    ) {
        UpdateReviewRequest updateReviewRequest = reviewMapper.fromDto(uReviewRequestDto);
        Review review = reviewService.updateReview(reviewId, updateReviewRequest);
        ReviewDto reviewDto = reviewMapper.toDto(review);
        return ResponseEntity.ok(reviewDto);
    }
}