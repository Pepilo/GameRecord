package com.pdg.backed.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.repository.ReviewRepository;
import com.pdg.backed.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(CreateReviewRequest request) {
        Review review = new Review(
            request.title(),
            request.content()
        );

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll(Sort.by(Sort.Direction.ASC, "reviewId"));
    }
}