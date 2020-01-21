package com.gabia.project.internproject.repository.review;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("select rev from Review rev where rev.restaurant= :restaruant")
    List<Review> getReviewListAtRestaurant(@Param("restaruant") Restaurant restaruant);
}
