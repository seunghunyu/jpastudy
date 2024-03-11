package com.study.jpastudy.chapter7.ex7_6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParentId implements Serializable {
    private String id1;
    private String id2;

}
