package com.study.jpastudy.chapter5;

import com.study.jpastudy.chapter5.Member;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TestMethod {
    public static void testSave(EntityManager em ) {
        Team team1 = new Team("team1", "팀1");
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);
        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }
    public static void queryLogicJoin(EntityManager em){
        String jpql = " select m from Member m join m.team t wehre t.name = :teamName";
        /**
         *  SELECT M.* FROM MEMBER WHERE MEMEBER INNER JOIN TEAM TEAM ON MEMBER.TEAM_ID = TEAM1_.ID
         *  WHERE TEAM1_.NAME = '팀1'
         */
        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for(Member member : resultList){
            System.out.println("[qry] member.username = "+ member.getUsername());
        }

    }

    public static void updateRelation (EntityManager em){
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    public static void deleteRelation (EntityManager em){
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null); //연관관계 제거
    }

    public void biDirection(EntityManager em){
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();
        for(Member member : members){
            System.out.println("[qry] member.username = "+ member.getUsername());
        }
    }
}
