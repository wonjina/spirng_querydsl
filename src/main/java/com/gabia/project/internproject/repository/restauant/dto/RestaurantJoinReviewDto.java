package com.gabia.project.internproject.repository.restauant.dto;

import lombok.Getter;

@Getter
public class RestaurantJoinReviewDto {

    private int id;
    private String name;
    private String category;
    private Long count;
    private double star;

    public RestaurantJoinReviewDto(int id, String name, String category, Long count) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.count = count;
    }

    public RestaurantJoinReviewDto(int id, String name, String category, double star) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.star = star;
    }

    public RestaurantJoinReviewDto(Long count, int id, String name, String category, double star) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.count = count;
        this.star = star;
    }
}
