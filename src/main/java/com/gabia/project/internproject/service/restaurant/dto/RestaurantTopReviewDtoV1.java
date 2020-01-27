package com.gabia.project.internproject.service.restaurant.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RestaurantTopReviewDtoV1 {

    private List<TopReviewColumnDtoV1> restaurants = new ArrayList<>();

    public RestaurantTopReviewDtoV1(List<TopReviewColumnDtoV1> restaurants) {
        this.restaurants = restaurants;
    }
}
