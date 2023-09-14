package com.jpa.basic.entity;

import com.jpa.basic.type.MemberType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_MEMBER") // 테이블 명 작성
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id는 PK로 설정할 필드 위에 작성하고, ORACLE에서 SEQ 자동 증가는 @GeneratedValue를 사용한다.
    @EqualsAndHashCode.Include //equals,hashcode 아래 필드로만 재정의
    private Long id;
    @NotNull // JAVA에서의 Validation(DB와 상관 없음) -> sun.istack.Notnull
    private String memberName;
    @Column(unique = true, nullable = false) // DBMS에서의 NOT NULL 제약조건 추가(JAVA와 상관 없음) -> 잘 쓰지 않음
    private String memberEmail;

    private String memberPassword;
    private int memberAge;
    @Enumerated(value = EnumType.STRING) // Enum  타입의 값을 DB에 저장 -> EnumType.ORDINAL ->순서를 저장 , EnumType.STRING -> 문자열 자체저장
                                            //순서로 저장할경우 중간에 새로운 값이 삽입되거나 여러가지경우 혼동을 줄 수 있으므로 문자열 자체를 저장함.
    private MemberType memberType;
}
