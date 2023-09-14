package com.jpa.basic.repository;

import com.jpa.basic.entity.Member;
import com.jpa.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setMemberName("한동석");
        member.setMemberAge(20);
        member.setMemberType(MemberType.ADMIN);
        member.setMemberPassword("1234");
        member.setMemberEmail("tedhan1204@gmail.com");

        memberRepository.save(member);
    }

    @Test
    public void findByIdTest(){
        memberRepository.findById(6L).map(Member::toString).ifPresent(log::info);

    }

    @Test
    public void findByMemberNameTest(){
        log.info(memberRepository.findByMemberName("한동석").get(0).toString());
    }

    @Test
    public void findByMemberNameContainingTest(){
        log.info(memberRepository.findByMemberNameContaining("한").get(0).toString());
    }

    @Test
    public void findByMemberNameStratingWithTest(){
        log.info(memberRepository.findByMemberNameStartingWith("한").get(0).toString());
    }

    @Test
    public void findByMemberNameEndingWithTest(){
        log.info(memberRepository.findByMemberNameEndingWith("석").get(0).toString());
    }

    @Test
    public void existsByMemberAgeTest(){
        log.info(String.valueOf(memberRepository.existsByMemberAge(21)));

    }

    @Test
    public void countAllByMemberTypeTest(){
        log.info(String.valueOf(memberRepository.countAllByMemberType(MemberType.ADMIN)));
        log.info(String.valueOf(memberRepository.countAllByMemberType(MemberType.MEMBER)));
    }

    @Test
    public void findAllTest(){
        assertThat(memberRepository.findAll()).hasSize(1);
    }

    @Test
    public void updateTest(){
        memberRepository.findById(6L).ifPresent(member -> member.setMemberName("홍길동"));
    }

    @Test
    public void deleteTest(){
        memberRepository.deleteById(6L);
    }

}



















