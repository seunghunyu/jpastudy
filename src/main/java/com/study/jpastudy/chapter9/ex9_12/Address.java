package com.study.jpastudy.chapter9.ex9_12;

import com.study.jpastudy.chapter9.ex9_6.Zipcode;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {
    @Column
    String city;
    String street;
    String state;
}
