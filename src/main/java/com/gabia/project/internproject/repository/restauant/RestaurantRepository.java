package com.gabia.project.internproject.repository.restauant;


import com.gabia.project.internproject.common.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer> {
    List<String> findCategoriesDistincBy();
    List<Restaurant> findRestaurantByRestaurantNumber(int id);
}
