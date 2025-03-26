package com.study.jpastudy.chapter8.data;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    private Date createdDate;
    private Date lastModifiedDate;

}
