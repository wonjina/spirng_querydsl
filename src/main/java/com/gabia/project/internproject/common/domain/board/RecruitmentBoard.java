package com.gabia.project.internproject.common.domain.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabia.project.internproject.common.domain.RecruitmentMember;
import com.gabia.project.internproject.common.domain.Restaurant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "recruitment_board")
@DiscriminatorValue("RecruitmentBoard")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitmentBoard extends Board{
    private int max_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "recruitment_board_id")
    private List<RecruitmentMember> recruitmentMembers;
}
