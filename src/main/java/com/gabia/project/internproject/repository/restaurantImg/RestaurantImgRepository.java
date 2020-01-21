package com.gabia.project.internproject.repository.restaurantImg;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.RestaurantImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantImgRepository extends JpaRepository<RestaurantImg, Integer> {
    List<RestaurantImg> findRestaurantImgsByrestaurant(Restaurant restaurant);
}
