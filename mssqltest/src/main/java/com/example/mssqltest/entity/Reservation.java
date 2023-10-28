package com.example.mssqltest.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name="reID")
    private Integer reID;
    @Column(name="seatID")
    private Long seatID;    //자리 id
    @Column(name="reservationName")
    private String reservationName; //예약자 이름 rename 예약어라서 reservationName 으로 표현
    @Column(name="reSTime")
    private LocalDateTime reSTime;    //예약 시작 시간
    @Column(name="reFTime")
    private LocalDateTime reFTime;    //예약 종료 시간
    @Column(name="reFDate")
    private LocalDate reFDate;
    @Column(name="reWDate")
    private LocalDate reWDate;
    @Column(name="mem_mbrid")
    private String memMbrId;

    @Builder
    public Reservation(Integer reID, Long seatID, String reservationName, LocalDateTime reSTime,
                       LocalDateTime reFTime, LocalDate reFDate, LocalDate reWDate, String memMbrId) {
        this.reID = reID;
        this.seatID = seatID;
        this.reservationName = reservationName;
        this.reSTime = reSTime;
        this.reFTime = reFTime;
        this.reFDate = reFDate;
        this.reWDate = reWDate;
        this.memMbrId = memMbrId;
    }
}
