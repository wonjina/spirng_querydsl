package com.gabia.project.internproject.service.restaurant.dto;

import com.gabia.project.internproject.common.domain.Review;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ReviewDto {
    private LocalDateTime date;
    private String comment;
    private int star;
    private String member_name;

    public ReviewDto(Review review) {
        this.date = review.getDate();
        this.comment = review.getComment();
        this.star = review.getRating();
        this.member_name = review.getMember().getName();
    }
}
