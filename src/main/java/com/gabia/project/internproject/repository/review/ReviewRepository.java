package com.gabia.project.internproject.repository.review;

import com.gabia.project.internproject.common.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findReviewByRestaurantNumber(int restaurant_number);
}
