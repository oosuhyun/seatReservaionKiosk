package com.example.mssqltest.mapper;

import com.example.mssqltest.dto.SeatResponse;
import com.example.mssqltest.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {
    public SeatResponse mapToDTO(Seat entity){
        return SeatResponse.builder()
                .seatID(entity.getSeatID())
                .seatStatus(entity.getSeatStatus())
                .seatFDate(entity.getSeatFDate())
                .academy(entity.getAcademy())
                .build();
    }
}
