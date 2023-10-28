package com.example.mssqltest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
public class SeatResponse {
    private Long seatID;
    private Integer seatStatus;
    private LocalDate seatFDate;
    private String academy;
}
