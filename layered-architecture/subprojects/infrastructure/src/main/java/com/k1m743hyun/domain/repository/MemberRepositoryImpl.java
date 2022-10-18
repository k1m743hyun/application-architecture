package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import com.k1m743hyun.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Optional<Member> getMember(Member member) {

        if (member.getId() != null) {
            return memberJpaRepository.findById(member.getId());
        } else {
            return memberJpaRepository.findByName(member.getName());
        }
    }

    @Override
    public Optional<Member> saveMember(Member member) {

        memberJpaRepository.save(member);

        return Optional.of(member);
    }

    @Override
    public Optional<Member> editMember(Member member) {
        return memberJpaRepository.findById(member.getId());
    }

    @Override
    public Optional<Member> deleteMember(Member member) {

        memberJpaRepository.deleteById(member.getId());

        return Optional.of(member);
    }
}