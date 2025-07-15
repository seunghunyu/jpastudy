package com.study.jpastudy.chapter7.ex7_10;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
public class Parent7_10 {
    @Id @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
