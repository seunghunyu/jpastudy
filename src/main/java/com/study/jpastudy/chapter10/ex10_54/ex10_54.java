package com.study.jpastudy.chapter10.ex10_54;

import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ex10_54 {
    EntityManager em;
    public void execCriteriaQry(){
        //JPQL: select m from Member m where m.username = '회원1' order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();

        //Criteria 생성, 반환 타입 지정
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class); // FROM 절

        //검색 조건 정의
        Predicate usernameEqual = cb.equal(m.get("username"), "회원1");

        //정렬 조건 정의
        jakarta.persistence.criteria.Order ageDesc = cb.desc(m.get("age"));

        cq.select(m) // SELECT 절
                .where(usernameEqual)
                .orderBy(ageDesc);

        TypedQuery<Member> query = em.createQuery(cq);
        List<Member> members = query.getResultList();
    }

    public void ex10_55(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));
    }
    //Object로 조회
    public void ex10_58(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> cq = cb.createQuery();
        Root<Member> m = cq.from(Member.class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        List<Object> resultList = em.createQuery(cq).getResultList();
    }
    //Object[]로 조회
    public void ex10_59(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Object[]> m = cq.from(Object[].class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        List<Object[]> resultList = em.createQuery(cq).getResultList();
    }
    //튜플로 조회
    public void ex10_61(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Object[]> m = cq.from(Object[].class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        List<Object[]> resultList = em.createQuery(cq).getResultList();
    }
}
