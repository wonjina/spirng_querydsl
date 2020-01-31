package com.gabia.project.internproject.repository.restauant.customRepository;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto;
import com.querydsl.core.Tuple;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<RestaurantJoinReviewDto> getRestaurantList(String name, String category, int limit, String sort, String sort_column);
}
