package com.gabia.project.internproject.common.domain.board;

import lombok.Getter;

import javax.persistence.*;

import java.time.LocalDateTime;



@Entity
@DiscriminatorColumn(name = "DTYPE")
@Getter
public abstract class Board {

    @Id
    @GeneratedValue
    @Column(name = "recruitment_board_id")
    private int id;

    private LocalDateTime date;
    private String subject;
}
