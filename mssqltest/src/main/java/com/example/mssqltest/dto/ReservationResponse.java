package com.example.mssqltest.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ReservationResponse {
    private Integer reID;
    private Long seatID;
    private String reservationName;
    private LocalDateTime reSTime;
    private LocalDateTime reFTime;
    private LocalDate reFDate;
    private LocalDate reWDate;
    private String memMbrId;

}
