package com.study.jpastudy.chapter7.ex7_6;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@IdClass(ParentId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent {
    @Id
    @Column(name = "PARENT_ID1")
    private String id1; //ParentId.id1과 연결
    @Id
    @Column(name = "PARENT_ID2")
    private String id2; //ParentId.id2과 연결

    private String name;


}
