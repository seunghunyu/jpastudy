package com.study.jpastudy.chapter8.data2;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Table(name = "T_MEMBER")
@Getter
@Setter
public class TMember {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public TMember(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public void setTeam(Team team){
        this.team = team;
        if(!team.getMembers().contains(this)){
            team.getMembers().add(this);
        }
    }
}
