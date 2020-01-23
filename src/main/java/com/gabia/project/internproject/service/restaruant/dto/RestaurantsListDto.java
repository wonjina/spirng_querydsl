package com.gabia.project.internproject.service.restaruant.dto;

import lombok.Getter;

@Getter
public class RestaurantsListDto {
    private int restaurant_id;
    private String name;
    private String cell_number;
    private String load_location;
    private String category;

    public RestaurantsListDto(int restaurant_id, String name, String cell_number, String load_location, String category) {
        this.restaurant_id = restaurant_id;
        this.name = name;
        this.cell_number = cell_number;
        this.load_location = load_location;
        this.category = category;
    }
}
