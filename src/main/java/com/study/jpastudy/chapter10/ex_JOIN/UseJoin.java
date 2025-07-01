package com.study.jpastudy.chapter10.ex_JOIN;

import com.study.jpastudy.chapter1.data1.Team;
import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UseJoin {
    @PersistenceContext
    EntityManager em;
    public void ex10_24(){
        String teamName = "팀A";
        String query = "SELECT m FROM Member m INNER JOIN m.team t "
                +" WHERE t.name = :teamName ";

        List<Member> members = em.createQuery(query, Member.class)
                .setParameter("teamName", teamName)
                .getResultList();

    }

    public void ex10_28(){
        String jpql = "select m from Member m join fetch m.team";
        List<Member> members = em.createQuery(jpql, Member.class).getResultList();

        for(Member member : members){
//            System.out.println("username = "+member.getUserName() + ", teamname = "+ member.getTeam.name() );
        }
    }
    public void ex10_31(){
        String jpql = "select t from Team t join fetch t.members where t.name = '팀A' ";
        List<Team> team =em.createQuery(jpql,Team.class).getResultList();
//        System.out.println("teamname = " + team.getName() + "team = " + team);

//        for(Member member : members){
//            System.out.println("username = "+member.getUserName() + ", teamname = "+ member.getTeam.name() );
//        }
    }

}
