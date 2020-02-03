package com.gabia.project.internproject.repository.review.customRepository;

import com.gabia.project.internproject.common.domain.QRestaurant;
import com.gabia.project.internproject.common.domain.QReview;
import com.gabia.project.internproject.common.domain.Review;
import com.gabia.project.internproject.repository.restauant.customRepository.RestaurantRepositoryCustom;
import com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl  implements ReviewRepositoryCustom {

    private final EntityManager em;

    public List<Review> getReviews(LocalDateTime dateTime){
        QReview review = QReview.review;
        //JPAQuery query = new JPAQuery(em);
        String str = "2022-01-01";
        JPAQueryFactory query = new JPAQueryFactory(em);

        JPAQuery query1 = query.selectFrom(review)
                .where(review.date.after(
                        Expressions.dateTimeTemplate(LocalDateTime.class,str)));
        return query1.fetch();
    }
}
