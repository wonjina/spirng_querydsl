package com.gabia.project.internproject.repository.review;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void 특정가게리뷰리스트가져오기(){
        List<Review> reviews = reviewRepository.getReviewListAtRestaurant(new Restaurant(2));
        for (Review review : reviews) {
            System.out.println(review.getComment()+","+review.getId());
        }
    }

}