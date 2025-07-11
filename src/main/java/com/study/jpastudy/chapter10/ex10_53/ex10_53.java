package com.study.jpastudy.chapter10.ex10_53;

import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ex10_53 {
    EntityManager em;
    public void execCriteriaQry(){
        //JPQL: select m from Member m
        CriteriaBuilder cb = em.getCriteriaBuilder();

        //Criteria 생성, 반환 타입 지정
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class); // FROM 절
        cq.select(m); // SELECT 절
        TypedQuery<Member> query = em.createQuery(cq);
        List<Member> members = query.getResultList();
    }
}
