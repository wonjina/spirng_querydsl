package com.gabia.project.internproject.common.domain;

import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "recruit_member")
public class RecruitMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_member_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_board_id")
    private RecruitBoard recruitBoard;

    public void setMember(Member member) {
        this.member=member;
        member.getRecruitMembers().add(this);
    }
    public void setRecruitBoard(RecruitBoard recruitBoard){
        this.recruitBoard = recruitBoard;
        recruitBoard.getRecruitMembers().add(this);
    }
}
