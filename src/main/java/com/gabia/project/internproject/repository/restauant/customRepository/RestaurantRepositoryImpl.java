package com.gabia.project.internproject.repository.restauant.customRepository;

import com.gabia.project.internproject.common.domain.QRestaurant;
import com.gabia.project.internproject.common.domain.Restaurant;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.constraints.Null;
import java.util.List;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    private final EntityManager em;

    @Override
    public List<Restaurant> getRestaurantList(String name, String category) {
        QRestaurant restaurant = QRestaurant.restaurant;
        JPAQueryFactory query = new JPAQueryFactory(em);

        return query.selectFrom(restaurant)
                .where(statusNameEq(name), statusCategoryEq(category))
                .fetch();
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
