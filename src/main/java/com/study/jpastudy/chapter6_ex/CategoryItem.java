package com.study.jpastudy.chapter6_ex;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "CATEGORY_ITEM")
public class CategoryItem {
    private Long categoryId;
    private Long itemId;
}
