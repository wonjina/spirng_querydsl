package com.gabia.project.internproject.service.restaruant;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.RestaurantRepository;
import com.gabia.project.internproject.repository.restauant.RestaurantImgRepository;
import com.gabia.project.internproject.repository.review.ReviewRepository;
import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import com.gabia.project.internproject.service.restaruant.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor //private final 객체 di 주입해주는듯
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final RestaurantImgRepository restaurantImgRepository;


    public CategoriesDto getCategoriesList(){
        return new CategoriesDto(restaurantRepository.getCategories());
    }
    public List<RestaurantDto> getRestaurantsList(String name, String category){
        return restaurantRepository.getRestaurantList(name, category).stream()
                .map(r->new RestaurantDto(r))
                .collect(Collectors.toList());
    }
    public RestaurantDetailDto getRestaurantInfo(int id){
        //리뷰 정보
        List<ReviewDto> reviews = reviewRepository.getReviewsAtRestaurant(id)
                .stream()
                .map(r->new ReviewDto(r)).collect(Collectors.toList());
        //가게 정보
        RestaurantDto restaurantDto = new RestaurantDto(restaurantRepository.findRestaurantByid(id));
        //가게 이미지
        List<RestaurantImgDto> restaurantImgDtos = restaurantImgRepository.getRestaurantImgs(id).stream().map(ri->new RestaurantImgDto(ri)).collect(Collectors.toList());

        RestaurantDetailDto restaurantDetailDto =  new RestaurantDetailDto(restaurantDto,reviews, restaurantImgDtos);
        return restaurantDetailDto;
    }

    //아래 2개의 함수 - AOP 적용예정
    public RestaurantTopStarDtoV1 getTopStarList(int limit){
        List<Integer> restaurantIdList = new ArrayList<>();

        List<ReviewGroupDto> reviewList =  reviewRepository.getGroupStar(limit);
        //reviewList.stream().map(r->restaurantIdList.add(r.getRestaurant_id()));//식당 기본키만 빼내는 작업
        for (ReviewGroupDto reviewGroupDto : reviewList) {
            restaurantIdList.add(reviewGroupDto.getRestaurant_id());
        }
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByidIn(restaurantIdList);


        List<TopStarColumnDto> topStarColumnDto =
                restaurants.stream()
                        .map(r->new TopStarColumnDto(r)).collect(Collectors.toList());
        int i=0;
        for (TopStarColumnDto starColumnDto : topStarColumnDto) {
            starColumnDto.setStar(reviewList.get(i++).getAvg());
        }

        //별점순으로 sorting 추가예정


        return new RestaurantTopStarDtoV1(topStarColumnDto);
    }

    public RestaurantTopReviewDtoV1 getTopAmoutReviewList(int limit){
        List<Integer> restaurantIdList = new ArrayList<>();

        List<ReviewGroupDto> reviewList =  reviewRepository.getGroupReview(limit);
        //reviewList.stream().map(r->restaurantIdList.add(r.getRestaurant_id()));//식당 기본키만 빼내는 작업
        for (ReviewGroupDto reviewGroupDto : reviewList) {
            restaurantIdList.add(reviewGroupDto.getRestaurant_id());
        }
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByidIn(restaurantIdList);


        List<TopReviewColumnDto> topStarColumnDto =
                restaurants.stream()
                        .map(r->new TopReviewColumnDto(r)).collect(Collectors.toList());
        int i=0;
        for (TopReviewColumnDto reviewColumnDto : topStarColumnDto) {
            reviewColumnDto.setReviewAmount(reviewList.get(i++).getCount());
        }

        //별점순으로 sorting 추가예정


        return new RestaurantTopReviewDtoV1(topStarColumnDto);
    }
}
