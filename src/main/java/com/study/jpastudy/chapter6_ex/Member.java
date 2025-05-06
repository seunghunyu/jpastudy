package com.study.jpastudy.chapter6_ex;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate   // 기본적인 Entity 수정은 모든 컬럼을 업데이트 하기 때문에 컬럼이 30개가 넘어가면 수정된 컬러만 업데이트되도록 사용
@DynamicInsert   // Field 가 빈 값인 애들을 제외하고 Insert 처리
@Getter @Setter
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue
    private String id;

    @Column(name = "NAME" , nullable = false, length = 10)
    private String username;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
