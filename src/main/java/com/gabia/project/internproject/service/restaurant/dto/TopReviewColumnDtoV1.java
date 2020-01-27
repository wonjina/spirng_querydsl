package com.gabia.project.internproject.service.restaurant.dto;

import com.gabia.project.internproject.common.domain.Restaurant;
import lombok.Getter;

@Getter
public class TopReviewColumnDtoV1 {
    private String name;
    private String phone;
    private String category;
    private String address;
    private Long review_amount;

    public void setReviewAmount(Long review_amount) {
        this.review_amount = review_amount;
    }

    public TopReviewColumnDtoV1(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.phone = restaurant.getCell_number();
        this.category = restaurant.getCategory();
        this.address = restaurant.getLoad_address();
    }
}
