package com.example.mssqltest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Integer reID;
    private Long seatID;
    private String reservationName;
    private LocalDateTime reSTime;
    private LocalDateTime reFTime;
    private String memMbrId;
}
