package com.gabia.project.internproject.repository.restauant.customRepository;

import com.gabia.project.internproject.common.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> getRestaurantList(String name, String category);
}
