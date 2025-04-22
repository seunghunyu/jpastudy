package com.study.jpastudy.chapter5_ex;

import com.study.jpastudy.chapter5_ex.Member;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TestMethod {
    public static void testSave(EntityManager em ) {
        Order order  = em.find(Order.class, "order1");
        Member member = order.getMember();

        OrderItem orderItem = order.getOrderItems().get(0);
        Item item = orderItem.getItem();
    }

}
