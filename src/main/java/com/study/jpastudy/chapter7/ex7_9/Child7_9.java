package com.study.jpastudy.chapter7.ex7_9;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(ChildId7_9.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Child7_9 {
    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent7_9 parent;

    @Id @Column(name = "CHILD_ID")
    private String childId;

    private String name;
}
