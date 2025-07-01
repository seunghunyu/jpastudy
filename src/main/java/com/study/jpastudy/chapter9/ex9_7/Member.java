package com.study.jpastudy.chapter9.ex9_7;

import com.study.jpastudy.chapter9.ex9_6.PhoneNumber;
import jakarta.persistence.*;

@Entity
public class Member {
    @Embedded Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name="COMPANTY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name="COMPANTY_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name="COMPANTY_ZIPCODE"))
    })
    Address companyAddress;
}
