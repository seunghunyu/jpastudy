package com.study.jpastudy.chapter10.ex10_48;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import javax.persistence.EntityManager;
import java.util.List;

@Entity
//@NamedQuery(
//        name= "Member.findByUsername",
//        query = "select m from Member m where m.username = :username"
//)
@NamedQueries({
    @NamedQuery(
        name= "Member.findByUsername",
        query = "select m from Member m where m.username = :username"),
    @NamedQuery(
                name= "Member.findByUsername",
                query = "select m from Member m where m.username = :username")
})
public class Member {
    EntityManager em;

    public void getUserName(){
        List<Member> resultList = em.createQuery("Member.findByUsername",
                Member.class)
                .setParameter("username","회원1").getResultList();

    }

}
