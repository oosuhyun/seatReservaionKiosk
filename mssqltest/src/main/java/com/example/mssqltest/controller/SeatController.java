package com.example.mssqltest.controller;


import com.example.mssqltest.dto.SeatResponse;
import com.example.mssqltest.service.ReservationService;
import com.example.mssqltest.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/seat")
@CrossOrigin(origins = "http://3.38.233.198:3000")
public class SeatController {

    private final SeatService seatService;
    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<SeatResponse>> getAll(){
        return ResponseEntity
                .ok(seatService.findAll());
    }
    //시작 시간 + 1시간 30동안 예약 있는 자리 찾고 예약 있는 자리는 seatStatus를 0으로 바꾸고, 없으면 1로 한다.
    @PutMapping("/130check/{startDateTime}")
    public ResponseEntity<Void> put130Seat(@PathVariable("startDateTime")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime){

        LocalDateTime endDateTime = startDateTime.plusHours(1).plusMinutes(30);

        List<Long> seatList = new ArrayList<>();
        System.out.println(startDateTime);
        System.out.println(endDateTime);


        //중복체크1+2
        int size = reservationService.findAllByReSTimeBetweenOrReFTimeBetween(startDateTime, endDateTime).size();
        for(int i=0; i<size; i++){
            seatList.add(reservationService.findAllByReSTimeBetweenOrReFTimeBetween(startDateTime, endDateTime).get(i).getSeatID());
        }
        //중복체크3
        size = reservationService.findAllByReSTimeBeforeAndReFTimeAfter(startDateTime, endDateTime).size();
        for(int i=0; i<size; i++){
            seatList.add(reservationService.findAllByReSTimeBeforeAndReFTimeAfter(startDateTime, endDateTime).get(i).getSeatID());
        }

        HashSet<Long> hash = new HashSet<>(seatList);

        List<Long> seatList2 = new ArrayList<>(hash);
//        System.out.println(seatList2);

        for(int i=1; i<=12; i++){
            if(seatList2.contains(Long.valueOf(i))){
                seatService.update((Long.valueOf(i)), 1);
            }
            else{
                seatService.update((Long.valueOf(i)), 0);
            }
        }

        for(int i=101; i<=108; i++){
            if(seatList2.contains(Long.valueOf(i))){
                seatService.update((Long.valueOf(i)), 1);
            }
            else{
                seatService.update((Long.valueOf(i)), 0);
            }
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    //시작 시간 + 2시간 30동안 예약 있는 자리 찾고 예약 있는 자리는 seatStatus를 0으로 바꾸고, 없으면 1로 한다.
    @PutMapping("/230check/{startDateTime}")
    public ResponseEntity<Void> put230Seat(@PathVariable("startDateTime")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime){

        LocalDateTime endDateTime = startDateTime.plusHours(2).plusMinutes(30);

        List<Long> seatList = new ArrayList<>();


        //중복체크1+2
        int size = reservationService.findAllByReSTimeBetweenOrReFTimeBetween(startDateTime, endDateTime).size();
        for(int i=0; i<size; i++){
            seatList.add(reservationService.findAllByReSTimeBetweenOrReFTimeBetween(startDateTime, endDateTime).get(i).getSeatID());
        }
        //중복체크3
        size = reservationService.findAllByReSTimeBeforeAndReFTimeAfter(startDateTime, endDateTime).size();
        for(int i=0; i<size; i++){
            seatList.add(reservationService.findAllByReSTimeBeforeAndReFTimeAfter(startDateTime, endDateTime).get(i).getSeatID());
        }

        HashSet<Long> hash = new HashSet<>(seatList);

        List<Long> seatList2 = new ArrayList<>(hash);

        for(int i=1; i<=11; i++){
            if(seatList2.contains(Long.valueOf(i))){
                seatService.update((Long.valueOf(i)), 1);
            }
            else{
                seatService.update((Long.valueOf(i)), 0);
            }
        }

        for(int i=101; i<=108; i++){
            if(seatList2.contains(Long.valueOf(i))){
                seatService.update((Long.valueOf(i)), 1);
            }
            else{
                seatService.update((Long.valueOf(i)), 0);
            }
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
