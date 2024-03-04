package com.study.jpastudy.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue
    @Column(name ="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
