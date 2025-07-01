package com.study.jpastudy.chapter10.ex10_10;

import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ParamUse {
    @PersistenceContext
    EntityManager em;
    public void sample(){
        String usernameParam = "User1";
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m where m.username = :username", Member.class);
        query.setParameter("username", usernameParam);
        List<Member> resultList = query.getResultList();
        for(Member member : resultList){
            System.out.println("member = " + member);
        }
    }
    public void sample2(){
        String usernameParam = "User1";
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m where m.username = ?1", Member.class);
        query.setParameter(1, usernameParam);
        List<Member> resultList = query.getResultList();
        for(Member member : resultList){
            System.out.println("member = " + member);
        }
    }
}
