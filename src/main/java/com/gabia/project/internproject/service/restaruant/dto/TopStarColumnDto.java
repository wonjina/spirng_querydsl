package com.gabia.project.internproject.service.restaruant.dto;


import com.gabia.project.internproject.common.domain.Restaurant;
import lombok.Getter;

@Getter
public class TopStarColumnDto {
    private String name;
    private String phone;
    private String category;
    private String address;
    private double star;

    public void setStar(double star) {
        this.star = star;
    }

    public TopStarColumnDto(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.phone = restaurant.getCell_number();
        this.category = restaurant.getCategory();
        this.address = restaurant.getLoad_address();
    }

    public TopStarColumnDto(Restaurant restaurant, double star) {
        this.name = restaurant.getName();
        this.phone = restaurant.getCell_number();
        this.category = restaurant.getCategory();
        this.address = restaurant.getLoad_address();
        this.star = star;
    }
}
