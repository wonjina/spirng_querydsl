package com.gabia.project.internproject.repository.review.dto;

import lombok.Getter;

@Getter
public class ReviewGroupDto {

    private int restaurant_id;
    private Long count;
    private double avg;

    public ReviewGroupDto(int restaurant_id, Long count) {
        this.restaurant_id = restaurant_id;
        this.count = count;
    }

    public ReviewGroupDto(int restaurant_id, double avg) {
        this.restaurant_id = restaurant_id;
        this.avg = avg;
    }

    public ReviewGroupDto(int restaurant_id, Long count, double avg) {
        this.restaurant_id = restaurant_id;
        this.count = count;
        this.avg = avg;
    }
}
