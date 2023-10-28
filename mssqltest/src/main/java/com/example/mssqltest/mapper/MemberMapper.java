package com.example.mssqltest.mapper;


import com.example.mssqltest.dto.MemberResponse;
import com.example.mssqltest.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

//    public Member mapToEntity(MemberRequest dto){
//        return Member.builder()
//                .mem_Pwd(dto.getMem_Pwd())
//                .mem_MbrName(dto.getMem_MbrName())
//                .build();
//    }

    public MemberResponse mapToDTO(Member entity){
        return MemberResponse.builder()
                .memMbrId(entity.getMemMbrId())
                .memTel(entity.getMemTel())
                .memMbrName(entity.getMemMbrName())
                .build();
    }
}
