package com.gabia.project.internproject.service.review.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ReviewsListDto {

    private int review_id;
    private LocalDate date;
    private String comment;
    private int star;
    private String user_name;

    public ReviewsListDto(int review_id, LocalDate date, String comment, int star, String user_name) {
        this.review_id = review_id;
        this.date = date;
        this.comment = comment;
        this.star = star;
        this.user_name = user_name;
    }
}
