package com.study.jpastudy.chapter8.data3;

//@Entity
//@DiscriminatorValue("B")
//@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item1 {

    private String author;
    private String isbn;

}
