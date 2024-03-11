package com.study.jpastudy.ex7.ex7_6;

import jakarta.persistence.*;

@Entity
public class Child {
    @Id
    private String id;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_iD2")
    }) //JoinColumn과 referencedColumnName 같으면 referencedColumnName 생략 가능
    private Parent parent;
}
