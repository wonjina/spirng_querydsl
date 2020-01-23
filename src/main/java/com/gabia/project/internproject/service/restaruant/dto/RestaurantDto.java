package com.gabia.project.internproject.service.restaruant.dto;

import com.gabia.project.internproject.common.domain.Restaurant;
import lombok.Getter;


@Getter
public class RestaurantDto {

    private int restaurant_id;
    private  String cell_phone;
    private String load_address;
    private String category;
    private String name;

    public RestaurantDto(Restaurant restaurant) {
        this.restaurant_id = restaurant.getId();
        this.cell_phone = restaurant.getCell_number();
        this.load_address = restaurant.getLoad_address();
        this.category = restaurant.getCategory();
        this.name = restaurant.getName();
    }
}
