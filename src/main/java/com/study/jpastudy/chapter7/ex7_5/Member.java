package com.study.jpastudy.chapter7.ex7_5;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
//@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "MEMBER_NAME"))
    }
)
public class Member extends BaseEntity {
    private String name;
}
