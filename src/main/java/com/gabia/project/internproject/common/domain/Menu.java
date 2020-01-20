package com.gabia.project.internproject.common.domain;


import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private int id;
    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurant;
}
