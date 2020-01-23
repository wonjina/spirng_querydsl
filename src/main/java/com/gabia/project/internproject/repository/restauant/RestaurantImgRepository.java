package com.gabia.project.internproject.repository.restauant;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.RestaurantImg;
import com.gabia.project.internproject.common.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantImgRepository extends JpaRepository<RestaurantImg, Integer> {
    List<RestaurantImg> findRestaurantImgsByrestaurant(Restaurant restaurant); //조인없이 조회
    List<RestaurantImg> findRestaurantImgsByRestaurantId(int id);//식당 조회해서 식당이미지 조회

    @Query("select ri from RestaurantImg ri where ri.restaurant.id= :id")
    List<RestaurantImg> getRestaurantImgs(@Param("id") int id); //조인없이 식당 이미지 조회

}
