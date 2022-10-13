package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Member save(Member member);

    @Override
    Optional<Member> findById(Long id);

    @Override
    Optional<Member> findByName(String name);

    @Override
    List<Member> findAll();
}
