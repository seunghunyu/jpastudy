package com.study.jpastudy.ex7.ex7_15;

import jakarta.persistence.*;

@Entity
public class Child7_15 {
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

}
