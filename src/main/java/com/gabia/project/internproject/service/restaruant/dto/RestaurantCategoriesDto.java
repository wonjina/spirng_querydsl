package com.gabia.project.internproject.service.restaruant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class RestaurantCategoriesDto {

    private String notice;
    private List<String> categories = new ArrayList<>();

    public RestaurantCategoriesDto(List<String> categories){
        this.categories = categories;
    }
    public void addCategory(String category){
        categories.add(category);
    }

}
