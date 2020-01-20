package com.gabia.project.internproject.common.domain.img;

import com.gabia.project.internproject.common.domain.Review;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@DiscriminatorValue("ReviewImg")
@Table(name = "review_img")
//@RequiredArgsConstructor
public class ReviewImg extends Image{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
}
