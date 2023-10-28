package com.example.mssqltest.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository  extends JpaRepository<Member, Long> {

    List<Member> findAllByMemMbrNameAndMemTelContaining(String name, String tel);

}
