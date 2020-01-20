package com.gabia.project.internproject.common.domain.img;

import com.gabia.project.internproject.common.domain.Restaurant;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@DiscriminatorValue("RestaurantImg")
@Table(name = "restaurant_img")
public class RestaurantImg extends Image{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurant;
}
