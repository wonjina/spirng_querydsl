package com.gabia.project.internproject.service.restaurant.dto;

import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import lombok.Getter;

import java.util.List;

@Getter
public class RestaurantTopStarDtoV2{

    private List<ReviewGroupDto> list;

    public RestaurantTopStarDtoV2(List<ReviewGroupDto> list) {
        this.list = list;
    }
}
