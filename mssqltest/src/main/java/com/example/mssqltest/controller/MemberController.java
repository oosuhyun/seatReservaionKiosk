package com.example.mssqltest.controller;



import com.example.mssqltest.dto.MemberResponse;
import com.example.mssqltest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/member")
@CrossOrigin(origins = "http://3.38.233.198:3000")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAll(){
        return ResponseEntity
                .ok(memberService.findAll());
    }
    @GetMapping("/check")
    public ResponseEntity<List<MemberResponse>> getAllByMemMbrNameAndMemPwd(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "tel") String tel
    ){
//        String mdscode = testMD5(password);
//        System.out.println(name);
//        System.out.println(password);
//        System.out.println(mdscode);

        if(memberService.findAllByMemMbrNameAndMemPwd(name,tel).isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not exist"
            );
        }
        return ResponseEntity
                    .ok(memberService.findAllByMemMbrNameAndMemPwd(name, tel));
    }

//    public static String testMD5(String str) {
//        String MD5 = "";
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(str.getBytes());
//            byte byteData[] = md.digest();
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < byteData.length; i++) {
//                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            MD5 = sb.toString();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            MD5 = null;
//        }
//        return MD5;
//    }

}
