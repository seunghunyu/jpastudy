package com.study.jpastudy.chapter7.ex7_7;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParentEm {

    @EmbeddedId
    private ParentEmId id;

    private String name;
}
