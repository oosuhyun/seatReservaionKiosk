package com.example.mssqltest.service;

import com.example.mssqltest.dto.MemberResponse;
import com.example.mssqltest.entity.Member;
import com.example.mssqltest.entity.MemberRepository;
import com.example.mssqltest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public List<MemberResponse> findAll(){
        return memberRepository.findAll()
                .stream()
                .map(memberMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MemberResponse> findAllByMemMbrNameAndMemPwd(String name, String tel){
        return memberRepository.findAllByMemMbrNameAndMemTelContaining(name, "-"+tel)
                .stream()
                .map(memberMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
