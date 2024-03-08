package com.study.jpastudy.data3;

import jakarta.persistence.*;

/*
   단일 테이블 전략
   *장점
   -조인이 필요 없으므로 조회성능이 빠르다
   -조회 쿼리가 단순
   *단점
   -자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야한다.
   -단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있다. 따라서 상황에 따라 조회 성능이 오히려 느려 질 수 있다.
   *특징
   - 구분 컬럼을 꼭 사용해야 한다. DisCriminatorColumn을 꼭 설정해야 한다.
    (설정하지 않으면 기본으로 엔티티 이름을 사용한다. (Movie, Book..)

 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item2 {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;

}
