package com.gabia.project.internproject.service.restaruant;

import com.gabia.project.internproject.service.restaurant.RestaurantService;
import com.gabia.project.internproject.service.restaurant.dto.RestaurantTopStarDtoV1;
import com.gabia.project.internproject.service.restaurant.dto.TopStarColumnDtoV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class RestaurantServiceTest {
    @Autowired
    RestaurantService restaurantService;

    @Test
    public void 별점높은가게리스트테스트(){
        RestaurantTopStarDtoV1 re = restaurantService.getTopStarList(3);
        for (TopStarColumnDtoV1 restaurant : re.getRestaurants()) {
            System.out.println(restaurant.getCategory()+","+restaurant.getName()+","+restaurant.getStar());
        }


    }

}