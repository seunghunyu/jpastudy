package com.study.jpastudy.chapter9.ex9_7;

import com.study.jpastudy.chapter9.ex9_6.Zipcode;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {
    String street;
    String city;
    String state;
    @Embedded
    Zipcode zipcode;
}
