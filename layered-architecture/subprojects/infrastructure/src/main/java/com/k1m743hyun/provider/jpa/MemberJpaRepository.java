package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}
