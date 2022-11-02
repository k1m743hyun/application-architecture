package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberQuerydslRepository {

    //private final JPAQueryFactory queryFactory;

    /**
     * 사용자 정보 조회
     */
    public Member getMember(Long id) {
        return Member.builder().build();
    }

    /**
     * 사용자 정보 등록
     */
    public Member saveMember() {
        return Member.builder().build();
    }

    /**
     * 사용자 정보 수정
     */
    public Member editMember() {
        return Member.builder().build();
    }

    /**
     * 사용자 정보 삭제
     */
    public Member deleteMember() {
        return Member.builder().build();
    }
}
