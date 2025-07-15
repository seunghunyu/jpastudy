package com.study.jpastudy.chapter8.ex8_1;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
public class Member8_1 {
    private String username;

    @ManyToOne
    private Team8_1 team;

}
