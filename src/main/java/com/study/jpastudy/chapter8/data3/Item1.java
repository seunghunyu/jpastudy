package com.study.jpastudy.chapter8.data3;

import jakarta.persistence.*;

/**
   조인 테이플 전략
   * 장점
 * - 테이블이 정규화된다.
 * - 외래 키 참조 무결성 제약조건을 활용할 수 있다.
 * - 저장공간을 효율적으로 사용한다.
 * * 단점
 * - 조회할 떄 조인이 많이 사용되므로 성능이 저하될 수 이싿.
 * - 조회 쿼리가 복잡하다.
 * - 데이터를 등록할 INSERT SQL을 두 번 실행한다.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item1 {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;

}
