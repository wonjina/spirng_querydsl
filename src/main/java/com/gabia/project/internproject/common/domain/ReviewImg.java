package com.gabia.project.internproject.common.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Table(name = "review_img")
//@RequiredArgsConstructor
public class ReviewImg {
    @Id
    @GeneratedValue
    @Column(name = "review_img_id")
    private int id;

    @NotEmpty
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
}
