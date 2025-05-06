package com.study.jpastudy.chapter7.ex7_1;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A") //엔티티 저장할때 구분컬럼에 입력할 값을 지정한다.
public class Album extends Item{
    private String artist;
}
