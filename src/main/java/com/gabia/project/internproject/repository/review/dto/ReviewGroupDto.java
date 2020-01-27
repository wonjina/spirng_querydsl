package com.gabia.project.internproject.repository.review.dto;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.common.domain.Review;
import lombok.Getter;

@Getter
public class ReviewGroupDto {


    private int restaurant_id;
    private String category;
    private String cell_number;
    private String load_address;
    private String name;
    private Long count;
    private double avg;

    public ReviewGroupDto( double avg ,Long count, int restaurant_id, String category, String cell_number, String load_address, String name) {
        this.restaurant_id = restaurant_id;
        this.category = category;
        this.cell_number = cell_number;
        this.load_address = load_address;
        this.name = name;
        this.count = count;
        this.avg = avg;
    }

    public ReviewGroupDto(double avg , int restaurant_id, String category, String cell_number, String load_address, String name) {
        this.restaurant_id = restaurant_id;
        this.category = category;
        this.cell_number = cell_number;
        this.load_address = load_address;
        this.name = name;
        this.avg = avg;
    }

    public ReviewGroupDto(Long count, int restaurant_id, String category, String cell_number, String load_address, String name) {
        this.restaurant_id = restaurant_id;
        this.category = category;
        this.cell_number = cell_number;
        this.load_address = load_address;
        this.name = name;
        this.count = count;
    }

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
