package com.study.jpastudy.ex7.ex7_18;

import com.study.jpastudy.ex7.ex7_17.Child7_17;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOARD7_18")
@SecondaryTable(name = "BOARD_DETAIL7_18", pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID")) /* 추가로 맵핑할 테이블 이름과 해당 테이블의 기본키 명을 적어준다.*/
/**
 *  여러 엔티티 맵핑시에 복수형으로 적어준다.
 *
 @SecondaryTables(
     {
     @SecondaryTable(name = "BOARD_DETAIL7_18", pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID")),
     @SecondaryTable(name = "BOARD_DETAIL7_18_2", pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
     }
 )
 */

public class Board7_18 {
    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;
    private String title;

    @Column(table = "BOARD_DETAIL")
    private String content;
}
