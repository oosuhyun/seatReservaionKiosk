package com.example.mssqltest.mapper;

import com.example.mssqltest.dto.ReservationRequest;
import com.example.mssqltest.dto.ReservationResponse;
import com.example.mssqltest.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public Reservation mapToEntity(ReservationRequest dto){
        return Reservation.builder()
                .reID(dto.getReID())
                .seatID(dto.getSeatID())
                .reservationName(dto.getReservationName())
                .reSTime(dto.getReSTime())
                .reFTime(dto.getReFTime())
                .memMbrId(dto.getMemMbrId())
                .build();
    }

    public ReservationResponse mapToDTO(Reservation entity){
        return ReservationResponse.builder()
                .reID(entity.getReID())
                .seatID(entity.getSeatID())
                .reservationName(entity.getReservationName())
                .reSTime(entity.getReSTime())
                .reFTime(entity.getReFTime())
                .reFDate(entity.getReFDate())
                .reWDate(entity.getReWDate())
                .memMbrId(entity.getMemMbrId())
                .build();
    }
}
