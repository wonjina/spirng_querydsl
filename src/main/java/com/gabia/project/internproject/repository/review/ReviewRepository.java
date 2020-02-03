package com.gabia.project.internproject.repository.review;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import com.gabia.project.internproject.repository.review.customRepository.ReviewRepositoryCustom;
import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> , ReviewRepositoryCustom {

    @Query("select rev from Review rev join fetch rev.member m where rev.restaurant.id= :restaruant")
    List<Review> getReviewsAtRestaurant(@Param("restaruant") int id /*Restaurant restaruant*/);

    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(r.restaurant.id, count(r), avg(r.star))" +
            " from Review r group by r.restaurant.id")
    List<ReviewGroupDto> getGroupReviewNStar();

    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(r.restaurant.id, count(r))" +
            " from Review r group by r.restaurant.id order by 1 ")
    List<ReviewGroupDto> getGroupReviewV1(@Param("limit") int limit);

    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(r.restaurant.id, avg(r.star))" +
            " from Review r group by r.restaurant.id order by 1 ")
    List<ReviewGroupDto> getGroupStarV1(@Param("limit") int limit);


    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(" +
            "count(r),r.restaurant.id,r.restaurant.category, r.restaurant.cell_number, r.restaurant.load_address, r.restaurant.name)" +
            " from Review r join r.restaurant res group by r.restaurant.id order by 1 desc ")
    List<ReviewGroupDto> getGroupReviewV2(@Param("limit") int limit);


    @Query("select new com.gabia.project.internproject.repository.review.dto.ReviewGroupDto(" +
            "avg(r),r.restaurant.id,r.restaurant.category, r.restaurant.cell_number, r.restaurant.load_address, r.restaurant.name)" +
            " from Review r join r.restaurant res group by r.restaurant.id order by 1 desc ")
    List<ReviewGroupDto> getGroupStarV2(@Param("limit") int limit); //join fetch error남



    //Test쿼리
    @Query("select res" +
            " from Restaurant res join fetch res.reviews rv ") //이너 조인이라 리뷰가 없는 가게는 안나옴. 리뷰없는 가게까지 가져오려면 left, right 조인 ㄱㄱ
    List<Restaurant> getGroupStarTest(@Param("limit") int limit);
    @Query("select r" +
            " from Review r join fetch r.restaurant res ") //이너 조인이라 리뷰가 없는 가게는 안나옴. 리뷰없는 가게까지 가져오려면 left, right 조인 ㄱㄱ
    List<Review> getGroupStarTest2(@Param("limit") int limit);

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
