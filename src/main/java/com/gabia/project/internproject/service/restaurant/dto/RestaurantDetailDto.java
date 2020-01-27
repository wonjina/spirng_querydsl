package com.gabia.project.internproject.service.restaurant.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RestaurantDetailDto {
    private RestaurantDto restaurant;
    private List<ReviewDto> reviews;
    private List<RestaurantImgDto> restaurantImgs;


    public RestaurantDetailDto(RestaurantDto restaurant, List<ReviewDto> reviews, List<RestaurantImgDto> restaurantImgs) {
        this.restaurant = restaurant;
        this.reviews = reviews;
        this.restaurantImgs = restaurantImgs;
    }
}
