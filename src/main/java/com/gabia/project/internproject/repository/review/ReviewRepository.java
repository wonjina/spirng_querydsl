package com.gabia.project.internproject.repository.review;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("select rev from Review rev join fetch rev.member m where rev.restaurant= :restaruant")
    List<Review> getReviewsAtRestaurant(@Param("restaruant") Restaurant restaruant);

    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(r.restaurant.id, count(r), avg(r.star))" +
            " from Review r group by r.restaurant.id")
    List<ReviewGroupDto> getGroupReviewNStar();

    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(r.restaurant.id, count(r))" +
            " from Review r group by r.restaurant.id order by 2 desc ")
    List<ReviewGroupDto> getGroupReview();

    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(r.restaurant.id, avg(r.star))" +
            " from Review r group by r.restaurant.id order by 2 desc ")
    List<ReviewGroupDto> getGroupStar();

   /*
    @Query("select new com.gabia.project.internproject.repository.restauant.dto.ReviewGroupingDto( r, count, avg)" +
            "from Restaurant r "+
            "where r.id in (select restaurant_id from Review rev group by rev.restaurant.id)"
              )
   @Query("select r from Review r")
   List<Review> getAllReview();

   @Query("select new com.gabia.project.internproject.repository.restauant.dto.ReviewGroupingDto(r.restaurant, count(r), avg(r.star))" +
           " from Review r group by r.restaurant")
   List<ReviewGroupingDto> getGroupingReview();
    @Query("select new com.gabia.project.internproject.repository.review.TestDto( res, count(r), avg(r.star) )" +
            "from Review r left join r.restaurant res  group by r.restaurant.id")
    List<TestDto> getFetch2();
   */

}
