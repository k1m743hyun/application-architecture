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

    /**
     * 조회
     */
    @Override
    public Optional<Member> getMember(Long id) {
        return memberJpaRepository.findById(id);
    }

    /**
     * 등록
     */
    @Override
    public void saveMember(Member member) {
        memberJpaRepository.save(member);
    }

    /**
     * 삭제
     */
    @Override
    public void deleteMember(Long id) {
        memberJpaRepository.deleteById(id);
    }
}