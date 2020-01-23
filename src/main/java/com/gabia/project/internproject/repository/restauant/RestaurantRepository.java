package com.gabia.project.internproject.repository.restauant;


import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import com.gabia.project.internproject.repository.restauant.customRepository.RestaurantRepositoryCustom;
import com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer>, RestaurantRepositoryCustom {
    @Query("select distinct r.category from Restaurant r")
    List<String> getCategories();   //식당 테이블에서 카테고리만 가져오는 쿼리(중복제거)
    List<Restaurant> findRestaurantByid(int id); //특정 가게 정보 (기본키로 검색)
    List<Restaurant> findRestaurantsByidIn(Collection<Integer> restaurant_ids);
    List<Restaurant> findAllRestaurantsBy();    //전체 가게 리스트
    List<Restaurant> findFilterListByNameAndCategory(String name, String category);
    @Query("select res from Restaurant res where res.name= :name and res.category=:category")
    List<Review> getReviewListAtRestaurant(@Param("name") String name, @Param("category") String category);



    @Query("select new com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto( res.id, res.name, res.category, count(r) )" +
            "from Review r left join r.restaurant res  group by r.restaurant.id order by 4 desc ")
    List<RestaurantJoinReviewDto> getTopReview();

    @Query("select new com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto( res.id, res.name, res.category, avg(r.star) )" +
            "from Review r left join r.restaurant res  group by r.restaurant.id order by 4 desc ")
    List<RestaurantJoinReviewDto> getTopStar();

    @Query("select new com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto( res.id, res.name, res.category, count(r), avg(r.star) )" +
            "from Review r left join r.restaurant res  group by r.restaurant.id")
    List<RestaurantJoinReviewDto> getGroupReviewNStar();
}
