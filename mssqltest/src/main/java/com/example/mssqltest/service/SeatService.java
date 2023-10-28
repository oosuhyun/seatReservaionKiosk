package com.example.mssqltest.service;

import com.example.mssqltest.dto.SeatResponse;
import com.example.mssqltest.entity.Seat;
import com.example.mssqltest.entity.SeatRepository;
import com.example.mssqltest.mapper.SeatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    public List<SeatResponse> findAll(){
        return seatRepository.findAll(Sort.by(Sort.Direction.ASC, "seatID"))
                .stream()
                .map(seatMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void update(Long seatID, Integer seatStatus){
        Seat seat = seatRepository.findById(seatID)
                .orElseThrow(() -> new IllegalArgumentException("해당 자리 없음"));
        seat.update(seatStatus);
    }
}
