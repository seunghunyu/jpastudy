package com.study.jpastudy.ex7_6;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ParentId.class)
public class Parent {
    @Id
    @Column(name = "PARENT_ID1")
    private String id1; //ParentId.id1과 연결
    @Id
    @Column(name = "PARENT_ID2")
    private String id2; //ParentId.id2과 연결

    private String name;


}
