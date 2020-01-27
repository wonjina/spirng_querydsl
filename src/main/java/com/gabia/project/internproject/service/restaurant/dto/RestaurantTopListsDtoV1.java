package com.gabia.project.internproject.service.restaurant.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RestaurantTopListsDtoV1 {
    private String doc_link;
    private List<RestaurantTopReviewDtoV1> restaurantTopReviewList ;
    private List<RestaurantTopStarDtoV1> restaurantTopStarList ;

    public RestaurantTopListsDtoV1(List<RestaurantTopReviewDtoV1> restaurantTopReviewList, List<RestaurantTopStarDtoV1> restaurantTopStarList) {
        this.restaurantTopReviewList = restaurantTopReviewList;
        this.restaurantTopStarList = restaurantTopStarList;
    }
}
