package com.gabia.project.internproject.service.restaruant.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RestaurantTopStarDtoV1 {

    private List<TopStarColumnDto> restaurants = new ArrayList<>();

    public RestaurantTopStarDtoV1(List<TopStarColumnDto> restaurants) {
        this.restaurants = restaurants;
    }

    public void setRestaurants(List<TopStarColumnDto> restaurants) {
        this.restaurants = restaurants;
    }
}
