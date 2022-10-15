package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import com.k1m743hyun.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

//    @Override
//    public Member save(Member member) {
//        return memberJpaRepository.save(member);
//    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberJpaRepository.findById(id);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberJpaRepository.findByName(name);
    }

//    @Override
//    public List<Member> findAll() {
//        return memberJpaRepository.findAll();
//    }
}