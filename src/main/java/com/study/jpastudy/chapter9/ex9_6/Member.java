package com.study.jpastudy.chapter9.ex9_6;

import jakarta.persistence.Embedded;

//@Entity
public class Member {
    @Embedded
    Address33 address;
    @Embedded
    PhoneNumber2 phoneNumber;
}
