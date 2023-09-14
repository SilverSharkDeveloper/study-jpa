package com.app.session.service;

import com.app.session.domain.MemberDTO;
import com.app.session.entity.Member;

import java.util.Optional;

public interface MemberService {
    public void join(MemberDTO memberDTO);
    public Optional<Member> login(String memberId, String memberPassword);

    public default Member toEntity(MemberDTO memberDTO){
        return Member.builder()
                .memberName(memberDTO.getMemberName())
                .memberId(memberDTO.getMemberId())
                .memberPassword(memberDTO.getMemberPassword())
                .memberEmail(memberDTO.getMemberEmail())
                .memberBirth(memberDTO.getMemberBirth())
                .memberPhoneNumber(memberDTO.getMemberPhoneNumber())
                .memberRole(memberDTO.getMemberRole())
                .build();
    }
}
