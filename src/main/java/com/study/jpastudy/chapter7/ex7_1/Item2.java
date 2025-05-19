package com.study.jpastudy.chapter7.ex7_1;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일 테이블 전략
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item2 {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
}
/**
 * 단일 테이블 전략 사용 시 자식 엔티티가 매핑한 컬럼은 모두 null을 허용해야한다는 점
 * 테이블이 커질 수 있음
 *
 * 종니이 필요 업으므로 조회 성능이 일반적으로는 빠름
 * 조회쿼리가 단순
 *
 * 구분컬럼을 꼭 사용해야함
 * @DiscriminatorValue를 지정하지 않으면 기본으로 엔티티 이름을 사용(Movie, Album, Book)
 */
