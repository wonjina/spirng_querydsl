package com.gabia.project.internproject.repository.restauant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RestaurantRepositoryTest {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    void findCategoriesDistincBy() {
        List<String> test = restaurantRepository.getCategories();
        for (String s : test) {
            System.out.println(s);
        }
    }

    @Test
    void findRestaurantByRestaurantNumber() {

    }
}