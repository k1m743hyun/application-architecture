package com.k1m743hyun.repository;

import com.k1m743hyun.data.entity.Member;
import java.util.Optional;

public interface MemberRepository {

    /**
     * 조회
     */
    Optional<Member> getMember(Member member);

    /**
     * 등록
     */
    Optional<Member> saveMember(Member member);

    /**
     * 삭제
     */
    Optional<Member> deleteMember(Member member);
}
