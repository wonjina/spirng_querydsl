package com.gabia.project.internproject.service.restaruant.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RestaruantCategoriesDto {

    private List<String> categories = new ArrayList<>();
    //private List<String> linkes = new ArrayList<>();

    public RestaruantCategoriesDto(List<String> categories){
        this.categories = categories;
    }

}
