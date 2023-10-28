package com.example.mssqltest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class MemberResponse {
    private String memMbrId;
    private String memTel;
    private String memMbrName;
}
