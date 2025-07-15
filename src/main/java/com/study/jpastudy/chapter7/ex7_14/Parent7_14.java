package com.study.jpastudy.chapter7.ex7_14;

import jakarta.persistence.*;

//@Entity
public class Parent7_14 {
    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    private String name;

    @OneToOne
    @JoinTable(name = "PARENT_CHILD",
            joinColumns = @JoinColumn(name = "PARENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
    private Child7_14 child;

}
