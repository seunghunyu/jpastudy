package com.study.jpastudy.ex7_5;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * MappedSuperclass로 지정한 클래스는 Entity 가 아니므로 em.find()나 JPQL에서 사용할 수 없다.
 * 해당 클래스를 직접 생성해서 사용할 일은 거의 없으므로 추상 클래스로 만드는 것을 권장
 * 사실상 테이블과는 관계가 없고 단순히 엔티티가 공통을 사용하는 매핑 정보를 모아주는 역할을 할 뿐
 * ORM에서 이야기하는 진정한 상속 매핑은 이전에 학습한 객체 상속을 데이터베이스의 슈퍼타입 서브타입 관계와 매핑하는 것이다.
 * !! @Entity는 @Entity이거나 @MappedSuperclass로 지정한 클래스만 상속받을 수 있다.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}