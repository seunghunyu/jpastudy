package com.study.jpastudy.chapter7_ex;

import jakarta.persistence.EntityManager;

public class TestMethod {
    public static void testSave(EntityManager em ) {
        Order order  = em.find(Order.class, "order1");
        Member member = order.getMember();

        OrderItem orderItem = order.getOrderItems().get(0);
        Item item = orderItem.getItem();
    }

}
