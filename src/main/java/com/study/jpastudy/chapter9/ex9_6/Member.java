package com.study.jpastudy.chapter9.ex9_6;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Member {
    @Embedded Address address;
    @Embedded PhoneNumber phoneNumber;
}
