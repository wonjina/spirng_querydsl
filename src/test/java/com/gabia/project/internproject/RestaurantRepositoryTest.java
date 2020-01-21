package com.gabia.project.internproject;

import com.gabia.project.internproject.common.domain.Restaurant;
import com.gabia.project.internproject.repository.restauant.RestaurantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
//@Rollback(false)
public class RestaurantRepositoryTest {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void 가게_저장_검색_테스트(){
        Restaurant restaurant = new Restaurant("aaaaa", "nnnnn");
        Restaurant tmp = restaurantRepository.save(restaurant);

        Restaurant findMember = restaurantRepository.findById(tmp.getId()).get();
        System.out.println(findMember.getId()+" "+findMember.getLoad_address());

        Assertions.assertThat(findMember.getId()).isEqualTo(restaurant.getId());        Assertions.assertThat(findMember.getLoad_address()).isEqualTo(restaurant.getLoad_address()) ;
        Assertions.assertThat(findMember).isEqualTo(restaurant);
    }
    @Test    public void basicCRUD() {
        Restaurant member1 = new Restaurant("member1","menu1");
        Restaurant member2 = new Restaurant("member2","menu2");
        restaurantRepository.save(member1);
        restaurantRepository.save(member2);
        //단건 조회 검증
        Restaurant findMember1 = restaurantRepository.findById(member1.getId()).get();
        Restaurant findMember2 = restaurantRepository.findById(member2.getId()).get();
        Assertions.assertThat(findMember1).isEqualTo(member1);
        Assertions.assertThat(findMember2).isEqualTo(member2);
        //리스트 조회 검증
        List<Restaurant> all = restaurantRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(5);
        // 숫자는 db 컬럼 숫자 + 위에 생성한 Restaurant 객체 객수로 설정하면됨

        //카운트 검증
        long count = restaurantRepository.count();
        Assertions.assertThat(count).isEqualTo(5);
        //삭제 검증
        restaurantRepository.delete(member1);
        restaurantRepository.delete(member2);
        long deletedCount = restaurantRepository.count();
        Assertions.assertThat(deletedCount).isEqualTo(3);
    }

}
