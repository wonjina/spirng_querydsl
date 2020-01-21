package com.gabia.project.internproject.repository.restauant;


import com.gabia.project.internproject.common.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer> {
    @Query("select distinct r.category from Restaurant r")
    List<String> getCategories();   //식당 테이블에서 카테고리만 가져오는 쿼리(중복제거)

    List<Restaurant> findRestaurantByid(int id);
}
