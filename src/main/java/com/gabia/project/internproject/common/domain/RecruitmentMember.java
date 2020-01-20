package com.gabia.project.internproject.common.domain;

import com.gabia.project.internproject.common.domain.board.Board;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "recruitment_member")
public class RecruitmentMember {
    @Id
    @GeneratedValue
    @Column(name = "recruitment_member_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
}
