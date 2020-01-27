package com.gabia.project.internproject.controller.restaurant;

import com.gabia.project.internproject.service.restaurant.RestaurantService;
import com.gabia.project.internproject.service.restaurant.dto.*;
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

    @GetMapping("/restaurant/v2/filter/topstarlist")
    public RestaurantTopStarDtoV2 getSortingStarListV2(){  return restaurantService.getTopStarListV2(LIMIT);  }

    @GetMapping("/restaurant/v2/filter/topreviewlist")
    public RestaurantTopReviewDtoV2 getSortingReviewListV2(){ return restaurantService.getTopAmoutReviewListV2(LIMIT); }

    @GetMapping("/restaurant/v1/filter/topstarlist")
    public RestaurantTopStarDtoV1 getSortingStarListV1(){
        return restaurantService.getTopStarListV1(LIMIT);
    }

    @GetMapping("/restaurant/v1/filter/topreviewlist")
    public RestaurantTopReviewDtoV1 getSortingReviewListV1(){ return restaurantService.getTopAmoutReviewListV1(LIMIT); }
/*

    //top 리뷰갯수, 별점 가게 정보 리스트들
    @GetMapping("/restaurant/v1/filter/toplists")
    public RestaurantTopListsDtoV1 getSortingListsV1(){ return null; }
*/

}
