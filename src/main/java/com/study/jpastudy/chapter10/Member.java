package com.study.jpastudy.chapter10;

import com.study.jpastudy.chapter9.ex9_12.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username; //상태 필드
    private Integer age; //상태 필드

    @ManyToOne
    private Team team; //연관 필드 (단일 값 연관 필드)

    @OneToMany
    private List<Order> orders; //연관 필드 (컬렉션 값 연관 필드)

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOODS",
        joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FODD_NAME")
    private Set<String> favoritesFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS",
            joinColumns = @JoinColumn(name="MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<Address>();

}
