package com.gabia.project.internproject.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabia.project.internproject.common.domain.board.Board;
import com.gabia.project.internproject.common.domain.board.RecruitmentBoard;
import com.gabia.project.internproject.common.domain.img.Image;
import com.gabia.project.internproject.common.domain.img.RestaurantImg;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class Restaurant {

    @Id
    @GeneratedValue
    @Column(name = "restaurant_number")
    private int id;

    private String cell_number;
    private String load_address;
    private int zip_code;
    private String category;
    private double location_x;
    private double location_y;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantImg> images = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<RecruitmentBoard> board = new ArrayList<>();
}
