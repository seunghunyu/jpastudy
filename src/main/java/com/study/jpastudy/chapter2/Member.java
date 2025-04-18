package com.study.jpastudy.chapter2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DynamicUpdate   // 기본적인 Entity 수정은 모든 컬럼을 업데이트 하기 때문에 컬럼이 30개가 넘어가면 수정된 컬러만 업데이트되도록 사용
@DynamicInsert   // Field 가 빈 값인 애들을 제외하고 Insert 처리
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String username;
    private Integer age;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
