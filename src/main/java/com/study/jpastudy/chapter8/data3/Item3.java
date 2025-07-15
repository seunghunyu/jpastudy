package com.study.jpastudy.chapter8.data3;

import jakarta.persistence.*;

/**
 *  구현 클래스마다 테이블 전략
 *  *장점
 *  - 서브 타입을 구분해서 처리할 때 효과적이다.
 *  - not null 제약조건을 사용할 수 있다.
 *  *단점
 *  - 여러 자식 테이블을 함께 조회할때 성능이 느리다(SQL에 UNION을 사용 해야한다.)
 *  - 자식 테이블을 통합해서 쿼리하기 어렵다.
 *  *특징
 *  - 구분 컬럼을 사용하지 않는다.
 *  - 데이터베이스 설계자와 ORM 전문가 둘 다 추천하지 않는 전략(조인이나 단일 테이플 전략을 쓸 것)
 */

//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item3 {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;
}
