package com.gabia.project.internproject.service.restaurant.dto;

import com.gabia.project.internproject.common.domain.RestaurantImg;
import lombok.Getter;

@Getter
public class RestaurantImgDto {
    private String url;

    public RestaurantImgDto(RestaurantImg restaurantImg) {
        this.url = restaurantImg.getUrl();
    }
}
