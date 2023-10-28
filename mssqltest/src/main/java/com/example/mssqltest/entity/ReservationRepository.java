package com.example.mssqltest.entity;


import com.example.mssqltest.mapper.ReservationMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    //해당시간과 좌석번호로 중복 체크 1
    List<Reservation> findAllByReSTimeBetweenAndSeatID(LocalDateTime startDateTime1, LocalDateTime endDateTime1, Long seat);
    //해당시간과 좌석번호로 중복 체크 2
    List<Reservation> findAllByReFTimeBetweenAndSeatID(LocalDateTime startDateTime1, LocalDateTime endDateTime1, Long seat);
    //해당시간과 좌석번호로 중복 체크 3
    List<Reservation> findAllByReSTimeBeforeAndReFTimeAfterAndSeatID(LocalDateTime startDateTime, LocalDateTime endDateTime, Long seat);



    //해당 시간에 예약 있는 자리 모두 찾기 1
    List<Reservation> findAllByReSTimeBetweenOrReFTimeBetween(LocalDateTime startDateTime1, LocalDateTime endDateTime1, LocalDateTime startDateTime2, LocalDateTime endDateTime2  );
    //해당 시간에 예약 있는 자리 모두 찾기 2
    List<Reservation> findAllByReSTimeBeforeAndReFTimeAfter(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<Reservation> findAll();

}
