package com.study.jpastudy.chapter7.ex7_17;

import jakarta.persistence.*;

//@Entity
public class Child7_17 {
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

}
