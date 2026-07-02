package com.pdg.backed.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.dto.CreateReviewRequestDto;
import com.pdg.backed.domain.review.dto.ReviewDto;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.domain.user.CreateUserRequest;
import com.pdg.backed.domain.user.dto.CreateUserRequestDto;
import com.pdg.backed.domain.user.dto.UserDto;
import com.pdg.backed.mapper.ReviewMapper;
import com.pdg.backed.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(
        @Valid
        @RequestBody
        CreateReviewRequestDto createReviewRequestDto
    ) {
        CreateReviewRequest createReviewRequest = reviewMapper.fromDto(createReviewRequestDto);
        Review review = reviewService.createReview(createReviewRequest);
        ReviewDto createReviewDto = reviewMapper.toDto(review);
        return new ResponseEntity<>(createReviewDto, HttpStatus.CREATED);
        
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        List<ReviewDto> reviewDtos = reviews.stream().map(reviewMapper::toDto).toList();
        return ResponseEntity.ok(reviewDtos);
    }
}
