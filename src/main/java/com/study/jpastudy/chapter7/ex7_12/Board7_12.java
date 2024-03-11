package com.study.jpastudy.chapter7.ex7_12;

import jakarta.persistence.*;

@Entity
public class Board7_12 {
    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;
    private String title;

    @OneToOne(mappedBy = "board")
    private BoardDetail7_12 boardDetail;
}
