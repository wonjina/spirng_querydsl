package com.gabia.project.internproject.repository.review.customRepository;

import com.gabia.project.internproject.common.domain.Review;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> getReviews(LocalDateTime dateTime);
}
