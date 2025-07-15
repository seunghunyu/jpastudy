package com.study.jpastudy.chapter7.ex7_10;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Embeddable
public class ChildId7_10 implements Serializable {
    private String parentId; //@MapId("parentId")로 맵핑
    private String parent;
    private String childId;
}
