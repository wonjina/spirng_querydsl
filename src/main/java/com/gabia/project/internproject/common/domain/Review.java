package com.gabia.project.internproject.common.domain;

import lombok.Getter;

import javax.persistence.*;

import java.time.LocalDateTime;


@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private int id;
    private LocalDateTime date;
    private String comment;
    private int star;
    private String member_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}
