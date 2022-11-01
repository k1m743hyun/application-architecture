package com.k1m743hyun.repository;

import com.k1m743hyun.data.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    /**
     * 사용자 조회
     */
    Optional<Member> getMemberByUserId(Long userId);

    /**
     * 사용자 조회
     */
    Optional<Member> getMemberByUserName(String userName);

    /**
     * 사용자 전체 조회
     */
    List<Member> getAllMembers();

    /**
     * 등록
     */
    void saveMember(Member member);

    /**
     * 삭제
     */
    void deleteMember(Long id);
}
