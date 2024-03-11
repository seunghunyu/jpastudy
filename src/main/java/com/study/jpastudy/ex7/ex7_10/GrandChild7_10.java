package com.study.jpastudy.ex7.ex7_10;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(GrandChildId7_10.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrandChild7_10 {

    @EmbeddedId
    private GrandChildId7_10 id;

    @MapsId("childId") //GrandChildId7_10.childId 맵핑
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })

    public Child7_10 child;

    private String name;
}
