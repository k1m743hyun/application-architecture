package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaEmRepository;
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

    //private final MemberJpaRepository memberRepository;
    private final MemberJpaEmRepository memberRepository;

    /**
     * 사용자 아이디로 사용자 정보 조회
     */
    @Override
    public Optional<Member> getMemberByUserId(Long userId) {
        return memberRepository.findById(userId);
    }

    /**
     * 사용자 이름으로 사용자 정보 조회
     */
    @Override
    public List<Member> getMemberByUserName(String userName) {
        return memberRepository.findByUserName(userName);
    }

    /**
     * 사용자 정보 전체 조회
     */
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    /**
     * 사용자 정보 등록
     */
    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    /**
     * 사용자 정보 삭제
     */
    @Override
    public void deleteMember(Long userId) {
        memberRepository.deleteById(userId);
    }
}