package com.k1m743hyun.repository;

import com.k1m743hyun.data.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    /**
     * 사용자 아아디로 사용자 정보 조회
     */
    Optional<Member> getMemberByUserId(Long userId);

    /**
     * 사용자 이름으로 사용자 정보 조회
     */
    List<Member> getMemberByUserName(String userName);

    /**
     * 사용자 정보 전체 조회
     */
    List<Member> getAllMembers();

    /**
     * 사용자 정보 등록
     */
    void saveMember(Member member);

    /**
     * 사용자 정보 삭제
     */
    void deleteMember(Long userId);
}
