package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    /**
     * 사용자 이름으로 사용자 정보 조회
     */
    List<Member> findByUserName(String userName);
}
