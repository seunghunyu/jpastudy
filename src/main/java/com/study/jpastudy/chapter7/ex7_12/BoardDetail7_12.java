package com.study.jpastudy.chapter7.ex7_12;

import jakarta.persistence.*;

//@Entity
public class BoardDetail7_12 {
    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board7_12 board;

    private String content;
}
