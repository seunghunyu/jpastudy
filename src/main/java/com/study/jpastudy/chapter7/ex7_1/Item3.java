package com.study.jpastudy.chapter7.ex7_1;

import jakarta.persistence.*;

//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //구현 클래스 마다 테이블 전략
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item3 {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
/**
 * 서브 타입을 구분해서 처리할 때 효과적이다, not null 제약조건을 사용할 수 있다.
 *
 * 여러 자식 테이블을 함께 조회할 때 성능이 느리다. (SQL에 UNION을 사용해야 한다.)
 * 자식 테입르을 통합해서 쿼리하기 어렵다.
 *
 * 구분컬럼을 사용하지 않는다.
 *
 */
