package com.gabia.project.internproject.service.restaruant.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RestaurantTopReviewDtoV1 {

    private List<TopReviewColumnDto> restaurants = new ArrayList<>();

    public RestaurantTopReviewDtoV1(List<TopReviewColumnDto> restaurants) {
        this.restaurants = restaurants;
    }
}
