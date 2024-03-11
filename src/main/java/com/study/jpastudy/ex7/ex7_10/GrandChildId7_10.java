package com.study.jpastudy.ex7.ex7_10;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrandChildId7_10 implements Serializable {

    private ChildId7_10 childId; //@MapsId("childId") 로 맵핑

    @Column(name = "GRANDCHILD_ID")
    private String id;
}
