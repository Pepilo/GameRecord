package com.pdg.backed.service;

import java.util.List;
import java.util.UUID;

import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.UpdateReviewRequest;
import com.pdg.backed.domain.review.entity.Review;
import com.pdg.backed.domain.user.entity.User;

public interface ReviewService {

    Review createReview(User user, CreateReviewRequest request);

    List<Review> getReviews();

    Review updateReview(UUID reviewId, UpdateReviewRequest request);

    // void deleteReview(UUID reviewId);
}
