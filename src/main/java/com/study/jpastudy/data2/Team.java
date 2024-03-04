package com.study.jpastudy.data2;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "TEAM")
public class Team {
    @Id
    @Column(name = "TEAM_ID")
    @NonNull
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


}
