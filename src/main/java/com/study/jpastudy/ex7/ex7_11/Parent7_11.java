package com.study.jpastudy.ex7.ex7_11;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Parent7_11 {

    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;
}
