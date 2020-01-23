package com.gabia.project.internproject.repository.restaurantImg;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.RestaurantImg;
import com.gabia.project.internproject.repository.restauant.RestaurantImgRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class RestaurantImgRepositoryTest {

    @Autowired
    RestaurantImgRepository restaurantImgRepository;

    @Test
    public void 특정음식점이미지리스트가져오기(){
        List<RestaurantImg> restaurantImgs = restaurantImgRepository.findRestaurantImgsByrestaurant(new Restaurant(1));
        for (RestaurantImg restaurantImg : restaurantImgs) {
            System.out.println(restaurantImg.getId()+","+restaurantImg.getRestaurant());
        }

        List<RestaurantImg> restaurantImgs2 = restaurantImgRepository.findRestaurantImgsByRestaurantId(1);
        for (RestaurantImg restaurantImg : restaurantImgs) {
            System.out.println(restaurantImg.getId()+","+restaurantImg.getRestaurant());
        }
    }

    @Test
    public void 식당아이디로_이미지_전체가져오기(){
        //식당 테이블과 조인 안되면 성공
        List<RestaurantImg> restaurantImgs = restaurantImgRepository.getRestaurantImgs(1);
        for (RestaurantImg restaurantImg : restaurantImgs) {
            System.out.println(restaurantImg.getId()+","+restaurantImg.getUrl());
        }
    }
}