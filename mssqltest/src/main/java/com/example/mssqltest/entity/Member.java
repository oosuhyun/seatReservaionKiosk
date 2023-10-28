package com.example.mssqltest.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "ek_Member")
public class Member {

    @Id
    @Column(name = "mem_MbrId")
    private String memMbrId;
    @Column(name="mem_TelNo2")
    private String memTel;
    @Column(name="mem_MbrName")
    private String memMbrName;


    @Builder
    public Member(String memMbrId, String memTel, String memMbrName) {
        this.memMbrId = memMbrId;
        this.memTel = memTel;
        this.memMbrName = memMbrName;
    }

    //    @Builder
//    public  Member(Long id, String name){
//        this.id = id;
//        this.name = name;
//    }
}
