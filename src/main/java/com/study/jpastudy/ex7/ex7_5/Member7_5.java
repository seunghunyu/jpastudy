package com.study.jpastudy.ex7.ex7_5;

import jakarta.persistence.Entity;

@Entity
//@AttributeOverride(name="id", column = @Column(name = "MEMBER_ID"))  //부모로부터 물려받은 매핑 정보를 재정의
//@AttributeOverrides({                                                //둘 이상을 재정의
//        @AttributeOverride(name="id", column = @Column(name = "MEMBER_ID")),
//        @AttributeOverride(name="name", column = @Column(name = "MEMBER_NAME"))
//})
public class Member7_5 extends BaseEntity{
    private String email;
}
