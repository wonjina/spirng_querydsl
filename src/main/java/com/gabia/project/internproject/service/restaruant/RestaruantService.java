package com.gabia.project.internproject.service.restaruant;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.RestaurantRepository;
import com.gabia.project.internproject.repository.restaurantImg.RestaurantImgRepository;
import com.gabia.project.internproject.repository.review.ReviewRepository;
import com.gabia.project.internproject.service.restaruant.dto.RestaruantCategoriesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class RestaruantService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final RestaurantImgRepository restaurantImgRepository;


    public List<RestaruantCategoriesDto> getCategoriesList(){

        return null;
    }
}
