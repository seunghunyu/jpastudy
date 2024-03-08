package com.study.jpastudy.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id @GeneratedValue
    @Column(name ="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;



}
