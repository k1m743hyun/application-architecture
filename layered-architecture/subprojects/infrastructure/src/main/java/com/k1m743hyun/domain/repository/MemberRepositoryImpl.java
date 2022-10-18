package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import com.k1m743hyun.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    /* 조회
     */
    @Override
    public Optional<Member> getMember(Member member) {
        return memberJpaRepository.findById(member.getId());
    }

    /* 등록
     */
    @Override
    public Optional<Member> saveMember(Member member) {

        memberJpaRepository.save(member);

        return Optional.of(member);
    }

    /* 수정
     */
//    @Override
//    public Optional<Member> editMember(Member member) {
//        return memberJpaRepository.findById(member.getId());
//    }

    /* 삭제
     */
    @Override
    public Optional<Member> deleteMember(Member member) {

        memberJpaRepository.deleteById(member.getId());

        return Optional.of(member);
    }
}