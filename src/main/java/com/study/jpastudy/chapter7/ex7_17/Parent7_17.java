package com.study.jpastudy.chapter7.ex7_17;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class Parent7_17 {
    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private List<Child7_17> child = new ArrayList<>();

}
