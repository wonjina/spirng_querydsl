package com.gabia.project.internproject.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabia.project.internproject.common.domain.RecruitmentMember;
import com.gabia.project.internproject.common.domain.Restaurant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "recruitment_board")
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitmentBoard{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_board_id")
    private int id;

    private LocalDateTime date;
    private String subject;

    private int max_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "recruitmentBoard")
    private List<RecruitmentMember> recruitmentMembers = new ArrayList<>();

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
        restaurant.getRecruitmentBoards().add(this);
    }
}
