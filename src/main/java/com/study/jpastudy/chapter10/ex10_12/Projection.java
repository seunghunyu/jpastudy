package com.study.jpastudy.chapter10.ex10_12;

import com.study.jpastudy.chapter10.Member;
import com.study.jpastudy.chapter10.UserDTO;
import com.study.jpastudy.chapter6.Product;
import jakarta.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Projection {
    @PersistenceContext
    EntityManager em;
    public void sample(){
        Query query = em.createQuery("SELECT m.username, m.age FROM Member m");
        List resultList = query.getResultList();

        Iterator iterator = resultList.iterator();
        while(iterator.hasNext()){
            Object[] row = (Object[]) iterator.next();
            String username = (String) row[0];
            Integer age = (Integer) row[1];
        }
    }
    public void sample2(){
        List<Object[]> resultList =
                em.createQuery("SELECT m.username, m.age FROM Member m")
                .getResultList();
        for(Object[] row : resultList){
            String username = (String) row[0];
            Integer age = (Integer) row[1];
        }
    }
    public void sample3(){

        List<Object[]> resultList =
                em.createQuery("SELECT o.member, 0.product, o.orderAmount FROM Order o")
                        .getResultList();
        for(Object[] row : resultList){
            Member member = (Member) row[0];
            Product product = (Product) row[1];
            int orderAmount = (Integer) row[2];
//            String username = (String) row[0];
//            Integer age = (Integer) row[1];
        }
    }

    public void sample4(){
        List<Object[]> resultList =
                em.createQuery("SELECT m.username, m.age FROM Member m")
                .getResultList();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(Object[] row : resultList){
            UserDTO userDTO = new UserDTO((String) row[0], (Integer)row[1]);
            userDTOs.add(userDTO);
        }
    }

    public void sample5(){
        TypedQuery<UserDTO> query =
                em.createQuery("SELECT new com.study.jpastudy.chapter10.UserDTO(m.username, m.age) " +
                        "FROM Member m", UserDTO.class);
        List<UserDTO> resultList = (List<UserDTO>) (query = (TypedQuery<UserDTO>) query.getResultList());
    }


}
