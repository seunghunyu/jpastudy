package com.study.jpastudy.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Album extends Item{
    private String artist;
    private String etc;
}
