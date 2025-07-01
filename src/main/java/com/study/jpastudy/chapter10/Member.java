package com.study.jpastudy.chapter10;

import com.study.jpastudy.chapter9.ex9_12.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String username;

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
