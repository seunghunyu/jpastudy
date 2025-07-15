package com.study.jpastudy.chapter7_ex;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@Entity
@DiscriminatorValue("B")
public class Movie {
    private String director;
    private String actor;
}
