package com.study.jpastudy.chapter7.ex7_6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ParentId2 implements Serializable {
    private String id1;
    private String id2;
}


/**
 * @IdClass를 사용할 때 식별자 클래스는 다음  조건을 만족해야한다.
 * 식별자 클래스의 속성ㅁ여과 엔티티에서 사용하는 식별자의 속성명이 같아야한다.
 * 예제의 Parent.id1 과 ParentId.id1 그리고 Parent.id2 와 ParentId.id2가 같다.
 * Serializable 인터페이스를 구현해야 한다.
 * equals, hashCode를 구현해야한다.
 * 기본 생성자가 있어야한다.
 * 식별자 클래스는 public 이어야 한다.
 */
