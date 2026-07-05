package com.pdg.backed.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.pdg.backed.domain.review.CreateReviewRequest;
import com.pdg.backed.domain.review.UpdateReviewRequest;
import com.pdg.backed.domain.review.dto.CreateReviewRequestDto;
import com.pdg.backed.domain.review.dto.ReviewDto;
import com.pdg.backed.domain.review.dto.UpdateReviewRequestDto;
import com.pdg.backed.domain.review.entity.Review;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    CreateReviewRequest fromDto(CreateReviewRequestDto dto);

    UpdateReviewRequest fromDto(UpdateReviewRequestDto dto);

    @Mapping(target = "author", source = "author")
    ReviewDto toDto(Review review);
}