package com.study.jpastudy.chapter8.ex8_12;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member8_12 {
    @Id
    private String id;
    private String username;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team8_12 team;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order8_12> orders = new ArrayList<>();

}
