package com.jpa.basic.repository;

import com.jpa.basic.entity.Member;
import com.jpa.basic.type.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    쿼리 메소드
//    메소드 이름으로 쿼리를 생성한다.
    public List<Member> findByMemberName(String memberName);
    public List<Member> findByMemberNameContaining(String memberName);
    public List<Member> findByMemberNameStartingWith(String memberName);
    public List<Member> findByMemberNameEndingWith(String memberName);
    public Boolean existsByMemberAge(int memberAge);
    public int countAllByMemberType(MemberType memberType);
}
