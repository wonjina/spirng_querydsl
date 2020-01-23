package com.gabia.project.internproject.controller.restaurant;

import com.gabia.project.internproject.service.restaruant.RestaurantService;
import com.gabia.project.internproject.service.restaruant.dto.RestaurantCategoriesDto;
import com.gabia.project.internproject.service.restaruant.dto.RestaurantsListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/categories")
    public RestaurantCategoriesDto categoriesList(){
        return restaurantService.getCategoriesList();
    }

    @GetMapping("/search")
    public List<RestaurantsListDto> getRestaurantsList(HttpServletRequest request){
        return restaurantService.getRestaurantsList(request.getParameter("name"),request.getParameter("category"));
    }
}
