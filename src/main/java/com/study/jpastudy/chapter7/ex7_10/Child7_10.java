package com.study.jpastudy.chapter7.ex7_10;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@IdClass(ChildId7_10.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Child7_10 {
    @EmbeddedId
    private ChildId7_10 id;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent7_10 parent;

    private String name;
}
