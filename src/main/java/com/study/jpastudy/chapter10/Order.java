package com.study.jpastudy.chapter10;

import com.study.jpastudy.chapter6.Member;
import com.study.jpastudy.chapter6.Product;
import jakarta.persistence.*;

//@Entity
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long Id ;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int orderAmount;

}
