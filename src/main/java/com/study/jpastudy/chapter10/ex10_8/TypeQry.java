package com.study.jpastudy.chapter10.ex10_8;

import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TypeQry {
    @PersistenceContext
    EntityManager em;
    public void sample(){

        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        List<Member> resultList = query.getResultList();
        for(Member member : resultList){
            System.out.println("member = " + member);
        }
    }
}
