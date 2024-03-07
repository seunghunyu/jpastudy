package com.study.jpastudy.data2;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEAM")
@Getter
@Setter
public class Team {
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<TMember> members = new ArrayList<>();


    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

   public void addMember(TMember member){
        this.members.add(member);
        if(member.getTeam() != this){
            member.setTeam(this);
        }
   }

}
