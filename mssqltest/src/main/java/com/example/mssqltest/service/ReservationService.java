package com.example.mssqltest.service;

import com.example.mssqltest.dto.ReservationRequest;
import com.example.mssqltest.dto.ReservationResponse;
import com.example.mssqltest.entity.Reservation;
import com.example.mssqltest.entity.ReservationRepository;
import com.example.mssqltest.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    //모든 자리 예약 가져오기(예약아이디로 정렬)
    public List<ReservationResponse> findAll(){
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //자리 예약 데이터 생성
    public void create(ReservationRequest request){
        Reservation reservation = reservationMapper.mapToEntity(request);
        System.out.println(reservation.getReservationName());
        System.out.println(reservation.getMemMbrId());
        System.out.println(reservation.getSeatID());
        System.out.println(reservation.getReSTime());
        System.out.println(reservation.getReID());
        System.out.println(reservation.getReFTime());
        System.out.println(reservation.getReFDate());
        System.out.println(reservation.getReWDate());
        reservationRepository.save(reservation);
    }

    //해당시간과 좌석번호로 중복 체크 1
    @Transactional
    public List<ReservationResponse> findAllByReSTimeBetweenAndSeatID(LocalDateTime startDateTime, LocalDateTime endDateTime, Long seat){
        return reservationRepository.findAllByReSTimeBetweenAndSeatID(startDateTime, endDateTime.minusSeconds(1), seat)
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    //해당시간과 좌석번호로 중복 체크 2
    @Transactional
    public List<ReservationResponse> findAllByReFTimeBetweenAndSeatID(LocalDateTime startDateTime, LocalDateTime endDateTime, Long seat){
        return reservationRepository.findAllByReFTimeBetweenAndSeatID(startDateTime.plusSeconds(1), endDateTime, seat)
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //해당시간과 좌석번호로 중복 체크 3
    @Transactional
    public List<ReservationResponse> findAllByReSTimeBeforeAndReFTimeAfterAndSeatID(LocalDateTime startDateTime, LocalDateTime endDateTime, Long seat){
        return reservationRepository.findAllByReSTimeBeforeAndReFTimeAfterAndSeatID(startDateTime, endDateTime, seat)
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //해당 시간에 예약 있는 자리 모두 찾기 1
    @Transactional
    public List<ReservationResponse> findAllByReSTimeBetweenOrReFTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime){
        return reservationRepository.findAllByReSTimeBetweenOrReFTimeBetween(startDateTime, endDateTime.minusSeconds(1), startDateTime.plusSeconds(1), endDateTime)
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //해당 시간에 예약 있는 자리 모두 찾기 2
    @Transactional
    public List<ReservationResponse> findAllByReSTimeBeforeAndReFTimeAfter(LocalDateTime startDateTime, LocalDateTime endDateTime){
        return reservationRepository.findAllByReSTimeBeforeAndReFTimeAfter(startDateTime, endDateTime)
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}
