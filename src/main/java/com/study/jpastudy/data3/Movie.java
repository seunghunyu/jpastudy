package com.study.jpastudy.data3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//@Entity
//@DiscriminatorValue("M")
public class Movie extends Item1 {
    private String director;
    private String actor;
}
