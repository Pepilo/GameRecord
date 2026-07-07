package com.pdg.backed.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.UpdateReviewRequest;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.domain.user.CreateUserRequest;
import com.pdg.backed.domain.user.entity.User;
import com.pdg.backed.exception.NotFoundException;
import com.pdg.backed.repository.ReviewRepository;
import com.pdg.backed.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(User user, CreateReviewRequest request) {
        Review review = new Review(
            request.title(),
            request.content(),
            user
        );

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll(Sort.by(Sort.Direction.ASC, "reviewId"));
    }

    @Override
    public Review updateReview(UUID reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new NotFoundException(reviewId));

        review.setTitle(request.title());
        review.setContent(request.content());

        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(UUID reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}