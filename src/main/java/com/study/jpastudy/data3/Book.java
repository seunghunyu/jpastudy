package com.study.jpastudy.data3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

//@Entity
//@DiscriminatorValue("B")
//@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item1 {

    private String author;
    private String isbn;

}
