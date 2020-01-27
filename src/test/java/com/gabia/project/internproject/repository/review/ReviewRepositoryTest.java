package com.gabia.project.internproject.repository.review;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void 특정가게리뷰리스트가져오기(){
        List<Review> reviews = reviewRepository.getReviewsAtRestaurant(1);
        for (Review review : reviews) {
            System.out.println(review.getComment()+","+review.getId()+","+review.getMember().getName());
        }
    }

    @Test
    public void 가게별_리뷰갯수_별점평균(){
        /*
        LocalDate currentDate = LocalDate.now();    // 컴퓨터의 현재 날짜 정보를 저장한 LocalDate 객체를 리턴한다. 결과 : 2016-04-01
        LocalDate targetDate = LocalDate.of(int year, int month, int dayOfMonth);
        LocalDate testDate = LocalDate.of(2020,1,12);
        */


        /*@Query("select r from Review r")
        List<Review> getAllReview();

        @Query("select new com.gabia.project.internproject.repository.restauant.dto.ReviewGroupingDto(r.restaurant, count(r), avg(r.star))" +
                " from Review r group by r.restaurant")
        List<ReviewGroupingDto> getGroupingReview(); //-> inner join 일어남. select query발생

        @Query("select new com.gabia.project.internproject.repository.restauant.dto.ReviewGroupingDto(r.restaurant.id, count(r), avg(r.star))" +
                " from Review r group by r.restaurant.id")
        List<ReviewGroupingDto> getGroupingReviewbyid();
        @Query("select new com.gabia.project.internproject.repository.review.TestDto( res.id, res.name, res.category, count(r), avg(r.star) )" +
                "from Review r left join r.restaurant res  group by r.restaurant.id") //->left outer join 발생
        List<TestDto> getFetch();
        @Query("select new com.gabia.project.internproject.repository.review.TestDto( res, count(r), avg(r.star) )" +
            "from Review r left join r.restaurant res  group by r.restaurant.id")
        List<TestDto> getFetch2();  ->res.id이외에는 select문 발생
        res 처럼 객체만 쓰면 pk값으로 치환되서 사용되는듯

        List<Review> test1 = reviewRepository.getAllReview();
        System.out.println("test1 end");

        List<ReviewGroupingDto> test2 = reviewRepository.getGroupingReview();
        for (ReviewGroupingDto reviewGroupingDto : test2) {
            System.out.println(reviewGroupingDto.getRestaurant()+
                    ","+reviewGroupingDto.getAvg()+","+reviewGroupingDto.getCount());
        }//->select발생
        System.out.println("test2 end");
        List<TestDto> test5 = reviewRepository.getFetch2();
        for (TestDto reviewGroupingDto : test5) {
            System.out.println(reviewGroupingDto.getRestaurant()+","+
                    reviewGroupingDto.getRestaurant().getId()+","+reviewGroupingDto.getRestaurant().getName()+","+reviewGroupingDto.getRestaurant().getCategory()+
                    ","+reviewGroupingDto.getStar()+","+reviewGroupingDto.getCount());
        }
        System.out.println("test5 end");
*/
        List<ReviewGroupDto> test3 = reviewRepository.getGroupReviewNStar();
        for (ReviewGroupDto reviewGroupingDto : test3) {
            System.out.println(reviewGroupingDto.getRestaurant_id()+
                    ","+reviewGroupingDto.getAvg()+","+reviewGroupingDto.getCount());
        }
        List<ReviewGroupDto> test4 = reviewRepository.getGroupReviewV1(1);
        List<ReviewGroupDto> test5 = reviewRepository.getGroupStarV1(1);

    }

    @Test
    void 쿼리어노테이션_패치조인사용하여_셀렉트문_설정테스트(){
           List<ReviewGroupDto> list = reviewRepository.getGroupStarV2(5);

        for (ReviewGroupDto r : list) {
            System.out.println(r.getAvg()+","+r.getName()+","+r.getRestaurant_id());
        }
        List<ReviewGroupDto> list2 = reviewRepository.getGroupReviewV2(5);

        for (ReviewGroupDto r : list2) {
            System.out.println(r.getCount()+","+r.getName()+","+r.getCategory()+","+r.getRestaurant_id());
        }

    }

    @Test
    void 쿼리어노테이션테스트(){
        List<Review> list = reviewRepository.getGroupStarTest2(3);
        for (Review r : list) {
            System.out.println(r.getComment()+","+r.getRestaurant().getName()+","+r.getRestaurant().getCategory());
        }
    }
}