package com.study.jpastudy.ex7.ex7_11;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(ChildId7_11.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Child7_11 {
    @Id @GeneratedValue
    @Column(name="CHILD_ID")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent7_11 parent;

}
