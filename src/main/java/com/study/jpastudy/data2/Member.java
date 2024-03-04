package com.study.jpastudy.data2;

import jakarta.persistence.*;

@Entity
@Table(name = "T_MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
