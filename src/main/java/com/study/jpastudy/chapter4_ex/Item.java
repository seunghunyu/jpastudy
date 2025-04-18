package com.study.jpastudy.chapter4_ex;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "ITEM")
public class Item {
    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "ITEM_NM")
    private String name;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "STOCK_QUANTITY")
    private Integer stockQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
