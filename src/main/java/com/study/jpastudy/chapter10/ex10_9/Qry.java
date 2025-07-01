package com.study.jpastudy.chapter10.ex10_9;

import com.study.jpastudy.chapter10.Member;
import jakarta.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Qry {
    @PersistenceContext
    EntityManager em;

    public void sample(){

        Query query = em.createQuery("SELECT m.username, m.age FROM Member m", Member.class);
        List resultList = query.getResultList();

        for(Object o : resultList){
            Object[] result = (Object[]) o ;
            System.out.println("username = " + result[0]);
            System.out.println("age = " + result[1]);
        }
    }
}
