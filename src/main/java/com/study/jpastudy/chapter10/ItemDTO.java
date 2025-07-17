package com.study.jpastudy.chapter10;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private String username;
    private int price;

    public ItemDTO(){}

    public ItemDTO(String username, int price) {
        this.username = username;
        this.price = price;
    }
}
