package com.gabia.project.internproject.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private String member_id;

    private String name;
    private String department;

    @JsonIgnore
    @OneToMany(mappedBy = "recruitment_board_id")
    private List<RecruitmentMember> recruitmentMembers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "review_id")
    private List<Review> reviews = new ArrayList<>();
}
