package com.study.jpastudy.chapter7.ex7_16;

import jakarta.persistence.*;

@Entity
public class Child7_16 {
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    @ManyToOne(optional = false)
    @JoinTable(name = "PARENT_CHILD", joinColumns = @JoinColumn(name = "CHILD_ID"), inverseJoinColumns = @JoinColumn(name="PARENT_ID"))
    private Parent7_16 parent;

}
