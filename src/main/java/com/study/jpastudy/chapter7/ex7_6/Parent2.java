package com.study.jpastudy.chapter7.ex7_6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent2 {
    @Id
    @EmbeddedId
    private ParentId2 id;

    private String name;



}
