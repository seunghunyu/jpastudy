package com.study.jpastudy.chapter7.ex7_9;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@IdClass(GrandChildId7_9.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrandChild7_9 {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })

    public Child7_9 child;

    @Id @Column(name = "GRAND_CHILD_ID")
    private String id;

    private String name;
}
