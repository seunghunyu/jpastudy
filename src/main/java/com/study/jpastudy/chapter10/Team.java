package com.study.jpastudy.chapter10;

import com.study.jpastudy.chapter6.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    @OneToMany(mappedBy = "team") //연관관계의 주인은 Member.team
    @JoinColumn(name = "TEAM_ID")
    private List<com.study.jpastudy.chapter6.Member> members = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.study.jpastudy.chapter6.Member> getMembers() {
        return members;
    }

    public void setMembers(List<com.study.jpastudy.chapter6.Member> members) {
        this.members = members;
    }

}
