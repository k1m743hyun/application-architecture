package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    /**
     * 조회
     */
    Optional<Member> findById(Long id);

    /**
     * 등록
     */
//    @Override
//    Optional<Member> save(Member member);

    /**
     * 삭제
     */
    @Override
    void deleteById(Long id);
}
