package com.study.jpastudy.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Book extends Item{
    private String author;
    private String isbn;
}
