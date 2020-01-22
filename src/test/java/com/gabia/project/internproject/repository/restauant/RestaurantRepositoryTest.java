package com.gabia.project.internproject.repository.restauant;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto;
import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class RestaurantRepositoryTest {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void 가게별_리뷰갯수_별점평균(){
        /*
        LocalDate currentDate = LocalDate.now();    // 컴퓨터의 현재 날짜 정보를 저장한 LocalDate 객체를 리턴한다. 결과 : 2016-04-01
        LocalDate targetDate = LocalDate.of(int year, int month, int dayOfMonth);
        LocalDate testDate = LocalDate.of(2020,1,12);
        */

        List<RestaurantJoinReviewDto> test1 = restaurantRepository.getGroupReviewNStar();
        for (RestaurantJoinReviewDto reviewGroupingDto : test1) {
            System.out.println(reviewGroupingDto.getId()+","+reviewGroupingDto.getName()+","+reviewGroupingDto.getCategory()+
                    ","+reviewGroupingDto.getStar()+","+reviewGroupingDto.getCount());
        }

        List<RestaurantJoinReviewDto> test2 = restaurantRepository.getTopReview();
        List<RestaurantJoinReviewDto> test3 = restaurantRepository.getTopStar();



    }

    @Test
    void findCategoriesDistincBy함수테스트() {
        List<String> test = restaurantRepository.getCategories();
        for (String s : test) {
            System.out.println(s);
        }
    }

    @Test
    void 검색시_가게이름_가게카테고리_필터_테스트(){
        //List<Restaurant> restaurants = restaurantRepository.getReviewListAtRestaurant();

    }

    @Test
    void findRestaurantByRestaurantNumber함수테스트() {
        List<Restaurant> restaurants = restaurantRepository.findAllRestaurantsBy();
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getId()+","+restaurant.getName());
        }
    }
    @Test
    void findRestaurantsByidIn함수테스트(){
/*
        Restaurant res1 =   new Restaurant(1);
        Restaurant res2 =   new Restaurant(2);*/
        List<Integer> reslist = new ArrayList<>();
        reslist.add(1);
        reslist.add(3);

        List<Restaurant> result = restaurantRepository.findRestaurantsByidIn(reslist);
        for (Restaurant restaurant : result) {
            System.out.println(restaurant.getId()+","+restaurant.getName());
        }
    }


    @Test
    public void 가게_저장_검색_테스트(){
        Restaurant restaurant = new Restaurant("aaaaa", "nnnnn");
        Restaurant tmp = restaurantRepository.save(restaurant);

        Restaurant findMember = restaurantRepository.findById(tmp.getId()).get();
        System.out.println(findMember.getId()+" "+findMember.getLoad_address());

        Assertions.assertThat(findMember.getId()).isEqualTo(restaurant.getId());
        Assertions.assertThat(findMember.getLoad_address()).isEqualTo(restaurant.getLoad_address()) ;
        Assertions.assertThat(findMember).isEqualTo(restaurant);
    }
    @Test
    public void basicCRUD() {
        Restaurant member1 = new Restaurant("member1","menu1");
        Restaurant member2 = new Restaurant("member2","menu2");
        restaurantRepository.save(member1);
        restaurantRepository.save(member2);
        //단건 조회 검증
        Restaurant findMember1 = restaurantRepository.findById(member1.getId()).get();
        Restaurant findMember2 = restaurantRepository.findById(member2.getId()).get();
        Assertions.assertThat(findMember1).isEqualTo(member1);
        Assertions.assertThat(findMember2).isEqualTo(member2);
        //리스트 조회 검증
        List<Restaurant> all = restaurantRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(5);
        // 숫자는 db 컬럼 숫자 + 위에 생성한 Restaurant 객체 객수로 설정하면됨

        //카운트 검증
        long count = restaurantRepository.count();
        Assertions.assertThat(count).isEqualTo(5);
        //삭제 검증
        restaurantRepository.delete(member1);
        restaurantRepository.delete(member2);
        long deletedCount = restaurantRepository.count();
        Assertions.assertThat(deletedCount).isEqualTo(3);
    }
}