package com.study.jpastudy.chapter4;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@DynamicUpdate   // 기본적인 Entity 수정은 모든 컬럼을 업데이트 하기 때문에 컬럼이 30개가 넘어가면 수정된 컬러만 업데이트되도록 사용
@DynamicInsert   // Field 가 빈 값인 애들을 제외하고 Insert 처리
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME","AGE"}
)})
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME" , nullable = false, length = 10)
    private String username;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RuleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

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

    public void setRoleType(RuleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum RuleType {
        ADMIN,USER
    }

}
