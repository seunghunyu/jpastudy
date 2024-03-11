package com.study.jpastudy.ex7.ex7_14;

import jakarta.persistence.*;

@Entity
public class Child7_14 {
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    //양방향 맵핑시 추가
    @OneToOne(mappedBy = "child")
    private Parent7_14 parent;
}
