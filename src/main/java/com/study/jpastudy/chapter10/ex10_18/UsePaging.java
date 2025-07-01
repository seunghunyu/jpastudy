package com.study.jpastudy.chapter10.ex10_18;

import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.PersistenceContext;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class UsePaging {
    @PersistenceContext
    EntityManager em;
    public void sample(){
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m ORDER BY m.username DESC", Member.class);

        query.setFirstResult(10);
        query.setMaxResults(20);
        query.getResultList();

        //FirstResult의 시작은 0이므로 11번째부터 시작해서 총 20건의 데이터를 조회
        //따라서 11~30번 데이터를 조회한다.
    }
}
