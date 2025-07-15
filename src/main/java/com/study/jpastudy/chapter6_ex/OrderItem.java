package com.study.jpastudy.chapter6_ex;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@Entity
@DynamicUpdate
@DynamicInsert
@Getter @Setter
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "ORDER_PRICE")
    private Integer orderPrice;

    @Column(name = "COUNT")
    private Integer count;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;
//    private List<Item> itemList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

}
