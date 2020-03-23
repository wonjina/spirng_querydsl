package com.gabia.project.internproject.repository.restauant.customRepository;

import com.gabia.project.internproject.common.domain.QRestaurant;
import com.gabia.project.internproject.common.domain.QReview;
import com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<RestaurantJoinReviewDto> getRestaurantList(String name, String category, int limit, String sort, String sort_column) {
        //sort = desc, asc / sort_column = count, avg
        QRestaurant restaurant = QRestaurant.restaurant;
        QReview review = QReview.review;
        RestaurantJoinReviewDto dto = new RestaurantJoinReviewDto();
        //JPAQuery query = new JPAQuery(em);
        JPAQueryFactory query = new JPAQueryFactory(em);

        JPAQuery query1 = query.select(Projections.fields(RestaurantJoinReviewDto.class,
                                                            restaurant.id.count().as("count"),
                                                            restaurant.id, 
                                                            restaurant.name, 
                                                            restaurant.category,
                                                            review.rating.avg().as("star")))
                                .from(review)
                                .join(review.restaurant, restaurant)
                                .where(statusNameEq(name), statusCategoryEq(category))
                                .groupBy(restaurant.id)
                                .orderBy(review.rating.avg().desc());
        if(limit>0) query1.limit(limit);
        return query1.fetch();

        /*
        //Case 1
        JPAQuery query1 = query.select(restaurant.id.count(),restaurant.id, restaurant.name, restaurant.category,review.star.avg())
                .from(review)
                .join(review.restaurant, restaurant)
                .where(statusNameEq(name), statusCategoryEq(category))
                .groupBy(restaurant.id)
                .orderBy(review.star.avg().desc());
        if(limit>0) query1.limit(limit);

        List<Tuple> result = query1.fetch();
        return result; //List<Tuple> return..
        */
    }
    private BooleanExpression statusNameEq(String str){
        if(!StringUtils.hasText(str)) return null;
        return QRestaurant.restaurant.name.eq(str);
    }

    private BooleanExpression statusCategoryEq(String str){
        if(!StringUtils.hasText(str)) return null;
        return QRestaurant.restaurant.category.eq(str);
    }
}
