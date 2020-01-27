package com.gabia.project.internproject.service.restaurant;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.RestaurantRepository;
import com.gabia.project.internproject.repository.restauant.RestaurantImgRepository;
import com.gabia.project.internproject.repository.restauant.dto.RestaurantJoinReviewDto;
import com.gabia.project.internproject.repository.review.ReviewRepository;
import com.gabia.project.internproject.repository.review.dto.ReviewGroupDto;
import com.gabia.project.internproject.service.restaurant.dto.*;
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
    public RestaurantTopStarDtoV1 getTopStarListV1(int limit){
        List<Integer> restaurantIdList = new ArrayList<>();

        List<ReviewGroupDto> reviewList =  reviewRepository.getGroupStarV1(limit);
        //reviewList.stream().map(r->restaurantIdList.add(r.getRestaurant_id()));//식당 기본키만 빼내는 작업
        for (ReviewGroupDto reviewGroupDto : reviewList) {
            restaurantIdList.add(reviewGroupDto.getRestaurant_id());
        }
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByidIn(restaurantIdList);


        List<TopStarColumnDtoV1> topStarColumnDto =
                restaurants.stream()
                        .map(r->new TopStarColumnDtoV1(r)).collect(Collectors.toList());
        int i=0;
        for (TopStarColumnDtoV1 starColumnDto : topStarColumnDto) {
            starColumnDto.setStar(reviewList.get(i++).getAvg());
        }

        //별점순으로 sorting 추가예정


        return new RestaurantTopStarDtoV1(topStarColumnDto);
    }

    public RestaurantTopReviewDtoV1 getTopAmoutReviewListV1(int limit){
        List<Integer> restaurantIdList = new ArrayList<>();

        List<ReviewGroupDto> reviewList =  reviewRepository.getGroupReviewV1(limit);
        //reviewList.stream().map(r->restaurantIdList.add(r.getRestaurant_id()));//식당 기본키만 빼내는 작업
        for (ReviewGroupDto reviewGroupDto : reviewList) {
            restaurantIdList.add(reviewGroupDto.getRestaurant_id());
        }
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByidIn(restaurantIdList);


        List<TopReviewColumnDtoV1> topReviewColumnDto =
                restaurants.stream()
                        .map(r->new TopReviewColumnDtoV1(r)).collect(Collectors.toList());
        int i=0;
        for (TopReviewColumnDtoV1 reviewColumnDto : topReviewColumnDto) {
            reviewColumnDto.setReviewAmount(reviewList.get(i++).getCount());
        }

        //리뷰갯수순으로 sorting 추가예정


        return new RestaurantTopReviewDtoV1(topReviewColumnDto);
    }


    public RestaurantTopListsDtoV1 getTopAmoutReviewNStarListV1(int limit){

        List<RestaurantJoinReviewDto> reviewNstar = restaurantRepository.getTopReviewNStar(limit);
        //sorting 2번 해서 아래 list들에 주입

        List<RestaurantTopReviewDtoV1> topReviewList = null;
        List<RestaurantTopStarDtoV1> topStarList=null;
        

        /*
        private List<RestaurantTopReviewDtoV1> restaurantTopReviewList = new ArrayList<>();
        private List<RestaurantTopStarDtoV1> restaurantTopStarList = new ArrayList<>();
        */

        return new RestaurantTopListsDtoV1(topReviewList, topStarList);
    }


    public RestaurantTopStarDtoV2 getTopStarListV2(int limit){
        return new RestaurantTopStarDtoV2(reviewRepository.getGroupStarV2(limit));
    }

    public RestaurantTopReviewDtoV2 getTopAmoutReviewListV2(int limit){
        return new RestaurantTopReviewDtoV2(reviewRepository.getGroupReviewV2(limit));
    }

}
