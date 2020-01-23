package com.gabia.project.internproject.service.restaruant;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.RestaurantRepository;
import com.gabia.project.internproject.repository.restauant.RestaurantImgRepository;
import com.gabia.project.internproject.repository.review.ReviewRepository;
import com.gabia.project.internproject.service.restaruant.dto.RestaurantCategoriesDto;
import com.gabia.project.internproject.service.restaruant.dto.RestaurantsListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor //private final 객체 di 주입해주는듯
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final RestaurantImgRepository restaurantImgRepository;


    public RestaurantCategoriesDto getCategoriesList(){
        return new RestaurantCategoriesDto(restaurantRepository.getCategories());
    }
    public List<RestaurantsListDto> getRestaurantsList(String name, String category){
        return restaurantRepository.getRestaurantList(name, category).stream()
                .map(r->new RestaurantsListDto(r.getId(), r.getName(),r.getCell_number(),r.getLoad_address(),r.getCategory()))
                .collect(Collectors.toList());
    }

}
