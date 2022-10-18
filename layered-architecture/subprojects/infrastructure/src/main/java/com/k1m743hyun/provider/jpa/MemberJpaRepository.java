package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    //@Override
    //Optional<Member> save(Member member);

    @Override
    void deleteById(Long id);
}
