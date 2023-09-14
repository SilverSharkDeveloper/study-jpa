package com.app.session.service;

import com.app.session.constant.Role;
import com.app.session.domain.MemberDTO;
import com.app.session.entity.Member;
import com.app.session.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(MemberDTO memberDTO) {
        memberDTO.setMemberRole(Role.MEMBER);
        memberRepository.save(toEntity(memberDTO));
    }

    @Override
    public Optional<Member> login(String memberId, String memberPassword) {
        return Optional.ofNullable(memberRepository.findByMemberIdAndMemberPassword(memberId, memberPassword));
    }
}
