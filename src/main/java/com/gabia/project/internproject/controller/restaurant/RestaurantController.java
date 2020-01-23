package com.gabia.project.internproject.controller.restaurant;

import com.gabia.project.internproject.service.restaruant.RestaurantService;
import com.gabia.project.internproject.service.restaruant.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final int LIMIT=5;

    @GetMapping("/categories")
    public CategoriesDto categoriesList(){
        return restaurantService.getCategoriesList();
    }

    @GetMapping("/search")
    public List<RestaurantDto> getRestaurantsList(HttpServletRequest request){
        return restaurantService.getRestaurantsList(request.getParameter("name"),request.getParameter("category"));
    }

    @GetMapping("/restaurant/detailInfo")
    public RestaurantDetailDto getRestaurantDetailInfo(HttpServletRequest request){
        RestaurantDetailDto restaurantDetailDto =restaurantService.getRestaurantInfo(Integer.parseInt(request.getParameter("id")));
        return restaurantDetailDto;
    }

    @GetMapping("/restaurant/v1/filter/topstarlist")
    public RestaurantTopStarDtoV1 getSortingStarListV1(){
        return restaurantService.getTopStarList(LIMIT);
    }

    @GetMapping("/restaurant/v1/filter/topreviewlist")
    public RestaurantTopReviewDtoV1 getSortingReviewListV1(){
        RestaurantTopReviewDtoV1 restaurantTopReviewDtoV1 = restaurantService.getTopAmoutReviewList(LIMIT);
        return restaurantTopReviewDtoV1;
    }
}
