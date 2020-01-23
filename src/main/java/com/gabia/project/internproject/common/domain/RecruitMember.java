package com.gabia.project.internproject.common.domain;

import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "recruitment_member")
public class RecruitMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_member_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruitment_board_id")
    private RecruitBoard recruitmentBoard;

    public void setMember(Member member) {
        this.member=member;
        member.getRecruitmentMembers().add(this);
    }
    public void setRecruitmentBoard(RecruitBoard recruitmentBoard){
        this.recruitmentBoard = recruitmentBoard;
        recruitmentBoard.getRecruitmentMembers().add(this);
    }
}
