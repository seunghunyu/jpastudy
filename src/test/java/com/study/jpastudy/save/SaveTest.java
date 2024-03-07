package com.study.jpastudy.save;

import com.study.jpastudy.data2.TMember;
import com.study.jpastudy.data2.Team;
import jakarta.persistence.*;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class SaveTest {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Test
    void testSave(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
        try {
//            tx.begin();

            Team team1 = new Team("team1", "팀1");
            em.persist(team1);

            TMember member1 = new TMember("member1", "회원1");
            member1.setTeam(team1);
            em.persist(member1);

            TMember member2 = new TMember("member2", "회원2");
            member2.setTeam(team1);
            em.persist(member2);

            TMember member = em.find(TMember.class, "member1");
            Team team = member.getTeam();

            team1.getMembers().add(member1);
            team1.getMembers().add(member2);
            em.persist(team1);

            log.info("member1 = {}", member1.getUsername());
            log.info("member2 = {}", member2.getUsername());
            log.info("team1 = {}", team1.getMembers());
//            System.out.println("member =" +  member.toString());
//            System.out.println("team =" +  team.toString());
//            tx.commit();
            qryLogicJoin(em);
//            updateTeam(em);
            getTeamtoMembers(em);

        }catch(Exception e){
            e.printStackTrace();
//            tx.rollback();
        }finally {
//            em.close();
        }
    }
    @Test
    void findData(){
        TMember member1 = em.find(TMember.class, "member1");
        Team team = member1.getTeam();

        log.info("member = {}, team = {}", member1, team);


    }

    private static void qryLogicJoin(EntityManager em){
        String jpql = "select m from TMember m join m.team t where t.name =:teamName ";
        List<TMember> memberList = em.createQuery(jpql, TMember.class)
                .setParameter("teamName","팀1")
                .getResultList();
        for(TMember member : memberList){
            log.info("[JPQL]member.userName = {}", member.getUsername());
        }
    }

    private static void updateTeam(EntityManager em){
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        TMember member = em.find(TMember.class, "member1");
        member.setTeam(team2);

        log.info("member 1 changedTeam = {}", member.getTeam());
    }

    private static void deleteRelation(EntityManager em){
        TMember member = em.find(TMember.class, "member1");
        member.setTeam(null);

        log.info("member 1 delete Team = {}", member.getTeam());

        /*  team2 엔티티 삭제시에는 연결된 릴레이션을 모두 제거해야함
            Team team = member1.getTeam();
            TMember member1 = em.find(TMember.class, "member1");
            member.setTeam(null);
            TMember member2 = em.find(TMember.class, "member2");
            member.setTeam(null);
            em.remove(team);
         */
    }

    private static void getTeamtoMembers(EntityManager em){
        try {
            Team team1 = em.find(Team.class, "team1");
            log.info("team1 = {} ", team1);

            List<TMember> members = team1.getMembers();

            for (TMember member : members) {
                log.info("biDirection member ={},  team = {}", member.getUsername(), member.getTeam().getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
