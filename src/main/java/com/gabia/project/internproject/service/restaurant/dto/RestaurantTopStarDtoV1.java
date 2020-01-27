package com.gabia.project.internproject.service.restaurant.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RestaurantTopStarDtoV1 {

    private List<TopStarColumnDtoV1> restaurants = new ArrayList<>();

    public RestaurantTopStarDtoV1(List<TopStarColumnDtoV1> restaurants) {
        this.restaurants = restaurants;
    }

    public void setRestaurants(List<TopStarColumnDtoV1> restaurants) {
        this.restaurants = restaurants;
    }
}
