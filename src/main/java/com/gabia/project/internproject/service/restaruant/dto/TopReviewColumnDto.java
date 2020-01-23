package com.gabia.project.internproject.service.restaruant.dto;

import com.gabia.project.internproject.common.domain.Restaurant;

public class TopReviewColumnDto {
    private String name;
    private String phone;
    private String category;
    private String address;
    private Long review_amount;

    public void setReviewAmount(Long review_amount) {
        this.review_amount = review_amount;
    }

    public TopReviewColumnDto(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.phone = restaurant.getCell_number();
        this.category = restaurant.getCategory();
        this.address = restaurant.getLoad_address();
    }
}
