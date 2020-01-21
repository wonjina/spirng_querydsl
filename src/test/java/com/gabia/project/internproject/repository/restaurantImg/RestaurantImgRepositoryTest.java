package com.gabia.project.internproject.repository.restaurantImg;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.RestaurantImg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    }
}