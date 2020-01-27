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
    @Column(name = "member_id")
    private String id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "member")
    private List<RecruitMember> recruitMembers = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();
}
