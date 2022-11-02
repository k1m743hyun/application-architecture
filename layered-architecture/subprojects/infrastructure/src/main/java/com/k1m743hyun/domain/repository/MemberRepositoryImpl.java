package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import com.k1m743hyun.repository.MemberRepository;
import java.util.List;
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
     * 상세 조회
     */
    @Override
    public Optional<Member> getMemberByUserId(Long userId) {
        return memberJpaRepository.findById(userId);
    }

    @Override
    public List<Member> getMemberByUserName(String userName) {
        return memberJpaRepository.findByUserName(userName);
    }

    /**
     * 리스트 조회
     */
    @Override
    public List<Member> getAllMembers() {
        return memberJpaRepository.findAll();
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
    public void deleteMember(Long userId) {
        memberJpaRepository.deleteById(userId);
    }
}