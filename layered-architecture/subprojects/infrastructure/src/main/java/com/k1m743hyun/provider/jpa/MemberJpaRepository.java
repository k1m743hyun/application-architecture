package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    List<Member> findByUserName(String userName);
}
