package com.study.jpastudy.chapter7.ex7_1;

import jakarta.persistence.*;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED) //상속매핑은 부모클래스에 @Inheritance 사용, 매핑 전략 지정 여기선 조인
@DiscriminatorColumn(name = "DTYPE") //부모 클래스에 구분 컬럼을 지정 이 컬럼으로 지정된 자식 테이블을 구분 할 수 있음.
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}

/**
 * 조인 전략 사용 시 장단점
 * - 장점
 * 1. 테이블이 정규화된다.
 * 2. 외래 키 참조 무결성 제약조건을 활용 할 수 있다.
 * 3. 저장공간을 효율적으로 사용한다.
 * - 단점
 * 1. 조회할 때 조인이 많이 사용되므로 성능이 저하 될 수 있다.
 * 2. 조회 쿼리가 복잡하다.
 * 3. 데이터를 등록할 INSERT SQL을 두번 실행 한다.
 *
 */