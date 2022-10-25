package com.k1m743hyun.repository;

import com.k1m743hyun.data.entity.Member;
import java.util.Optional;

public interface MemberRepository {

    /**
     * 조회
     */
    Optional<Member> getMember(Long id);

    /**
     * 등록
     */
    void saveMember(Member member);

    /**
     * 삭제
     */
    void deleteMember(Long id);
}
