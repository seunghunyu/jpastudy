package com.study.jpastudy.ex7.ex7_9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildId7_9 implements Serializable {
    private String parent;
    private String childId;
}
