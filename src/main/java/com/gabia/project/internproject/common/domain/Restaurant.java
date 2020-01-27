package com.gabia.project.internproject.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int id;

    private String cell_number;
    private String load_address;
    private int zip_code;
    private String category;
    private double location_x;
    private double location_y;
    private String name;

    public Restaurant( int id){
        this.id = id;
    }
    public Restaurant( String load_address , String name){
        this.load_address =load_address; this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantImg> restaurantImgs = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<RecruitBoard> recruitBoards = new ArrayList<>();
}
