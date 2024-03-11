package com.study.jpastudy.chapter7.ex7_11;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrandChild7_11 {

    @Id @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    private Long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })

    public Child7_11 child;

    private String name;
}
