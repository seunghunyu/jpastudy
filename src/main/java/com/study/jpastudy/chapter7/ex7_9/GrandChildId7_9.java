package com.study.jpastudy.chapter7.ex7_9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrandChildId7_9 implements Serializable {
    private ChildId7_9 child;
    private String id;
}
