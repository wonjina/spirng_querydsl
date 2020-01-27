package com.gabia.project.internproject.service.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class CategoriesDto {

    private String notice;
    private List<String> categories = new ArrayList<>();

    public CategoriesDto(List<String> categories){
        this.categories = categories;
    }
    public void addCategory(String category){
        categories.add(category);
    }

}
