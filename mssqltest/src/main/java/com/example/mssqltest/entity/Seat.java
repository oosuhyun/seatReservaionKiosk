package com.example.mssqltest.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Seat {
    @Id
    private Long seatID;
    private Integer seatStatus;
    private LocalDate seatFDate;
    private String academy;

    @Builder
    public Seat(Long seatID, Integer seatStatus, LocalDate seatFDate, String academy) {
        this.seatID = seatID;
        this.seatStatus = seatStatus;
        this.seatFDate = seatFDate;
        this.academy = academy;
    }

    @Builder
    public void update(Integer seatStatus){
        this.seatStatus = seatStatus;
    }

}
