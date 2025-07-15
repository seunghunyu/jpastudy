package com.study.jpastudy.chapter7_ex;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@Entity
@DiscriminatorValue("A")
public class Album {
    private String artist;
    private String etc;
}
