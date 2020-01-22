package com.gabia.project.internproject.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int id;

    private LocalDate date;
    private String comment;
    private int star;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy="review")
    private List<ReviewImg> reviewImgs = new ArrayList<>();

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
        restaurant.getReviews().add(this);
    }
    public void setMember(Member member){
        this.member = member;
        member.getReviews().add(this);
    }

}
