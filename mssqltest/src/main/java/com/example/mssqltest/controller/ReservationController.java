package com.example.mssqltest.controller;

import com.example.mssqltest.dto.ReservationRequest;
import com.example.mssqltest.dto.ReservationResponse;
import com.example.mssqltest.entity.ReservationRepository;
import com.example.mssqltest.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reservation")
@CrossOrigin(origins = "http://3.38.233.198:3000")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    //모든 자리 예약 가져오기(예약아이디로 정렬)
    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAll(){
        return ResponseEntity
                .ok(reservationService.findAll());
    }

    //자리 예약 데이터 생성(중복체크 후)
    @PostMapping("/res130")
    public ResponseEntity<Void> create120(@RequestBody ReservationRequest dto){

        dto.setReFTime(dto.getReSTime().plusMinutes(90));
        int size = reservationRepository.findAll().size();
//        System.out.println(size);
//        System.out.println(reservationRepository.findAll().get(size-1).getReID()+1);

//        int max = 0;
//        int dirID = 0;
//        if(size != 0){
//            for(int i=0; i<size; i++){
//                if(Integer.compare(reservationRepository.findAll().get(i).getReID(), max) == 1){
//                    max = reservationRepository.findAll().get(i).getReID();
//                }
//            }
//            dirID = max;
//        }
        dto.setReID(reservationRepository.findAll().get(size-1).getReID()+1);

        if(reservationService.findAllByReSTimeBetweenAndSeatID(dto.getReSTime(), dto.getReFTime(), dto.getSeatID()).isEmpty()){
            if (reservationService.findAllByReFTimeBetweenAndSeatID(dto.getReSTime(), dto.getReFTime(), dto.getSeatID()).isEmpty()) {
                if(reservationService.findAllByReSTimeBeforeAndReFTimeAfterAndSeatID(dto.getReSTime(), dto.getReFTime(), dto.getSeatID()).isEmpty()){
                    reservationService.create(dto);
                }else {
                    throw new ResponseStatusException(
                            HttpStatus.CONFLICT, "already exist"
                    );
                }
            } else {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "already exist"
                );
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "already exist"
            );
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/res230")
    public ResponseEntity<Void> create230(@RequestBody ReservationRequest dto){

//        LocalDateTime endDateTime = dto.getReSTime().plusHours(1).plusMinutes(30);
        dto.setReFTime(dto.getReSTime().plusMinutes(150));

        int size = reservationRepository.findAll().size();
//        int max = 0;
//        int dirID = 0;
//        if(size != 0){
//            for(int i=0; i<size; i++){
//                if(Integer.compare(reservationRepository.findAll().get(i).getReID(), max) == 1){
//                    max = reservationRepository.findAll().get(i).getReID();
//                }
//            }
//            dirID = max;
//        }
        dto.setReID(reservationRepository.findAll().get(size-1).getReID()+1);


        if(reservationService.findAllByReSTimeBetweenAndSeatID(dto.getReSTime(), dto.getReFTime(), dto.getSeatID()).isEmpty()){
            if (reservationService.findAllByReFTimeBetweenAndSeatID(dto.getReSTime(), dto.getReFTime(), dto.getSeatID()).isEmpty()) {
                if(reservationService.findAllByReSTimeBeforeAndReFTimeAfterAndSeatID(dto.getReSTime(), dto.getReFTime(), dto.getSeatID()).isEmpty()){
                    reservationService.create(dto);
                }else {
                    throw new ResponseStatusException(
                            HttpStatus.CONFLICT, "already exist"
                    );
                }
            } else {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "already exist"
                );
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "already exist"
            );
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
