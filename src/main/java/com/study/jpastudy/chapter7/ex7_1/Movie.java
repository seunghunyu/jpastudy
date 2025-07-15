package com.study.jpastudy.chapter7.ex7_1;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//@Entity
@DiscriminatorValue("M")
public class Movie extends Item{
    private String director; //감독
    private String actor;    //배우
}
