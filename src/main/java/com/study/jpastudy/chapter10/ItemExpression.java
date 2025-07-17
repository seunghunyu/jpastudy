package com.study.jpastudy.chapter10;

import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.study.jpastudy.chapter4_ex.Item;
import com.study.jpastudy.chapter4_ex.QItem;

public class ItemExpression {
    @QueryDelegate(Item.class)
    public static BooleanExpression isExpensive(QItem item, Integer price){
        return item.price.gt(price);
    }
}
