package com.study.jpastudy.data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Orders {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderData;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
