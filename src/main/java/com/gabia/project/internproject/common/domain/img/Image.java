package com.gabia.project.internproject.common.domain.img;


import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Getter
public abstract class Image {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private int id;

    @NotEmpty
    private String url;
}
