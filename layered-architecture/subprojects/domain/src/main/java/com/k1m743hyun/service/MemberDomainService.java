package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class MemberDomainService extends Exception {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    /**
     * 조회
     */
    public Optional<Member> getMember(MemberRequestDto requestDto) {
        return memberRepository.getMember(memberMapper.toEntity(requestDto));
    }

    /**
     * 등록
     */
    public Optional<Member> saveMember(MemberRequestDto requestDto) {
        return memberRepository.saveMember(memberMapper.toEntity(requestDto));
    }

    /**
     * 수정
     */
    public Optional<Member> editMember(MemberRequestDto requestDto) {

        Optional<Member> member = memberRepository.getMember(memberMapper.toEntity(requestDto));

        member.ifPresent(value -> value.update(requestDto.getName()));

        return member;
    }

    /**
     * 삭제
     */
    public Optional<Member> deleteMember(MemberRequestDto requestDto) {
        return memberRepository.deleteMember(memberMapper.toEntity(requestDto));
    }
}