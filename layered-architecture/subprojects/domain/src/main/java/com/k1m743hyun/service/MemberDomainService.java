package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class MemberDomainService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    /**
     * 조회
     */
    public Member getMember(MemberRequestDto requestDto) {
        return memberRepository.getMember(memberMapper.toEntity(requestDto)).orElseThrow();
    }

    /**
     * 등록
     */
    public Member saveMember(MemberRequestDto requestDto) {
        return memberRepository.saveMember(memberMapper.toEntity(requestDto)).orElseThrow();
    }

    /**
     * 수정
     */
    public Member editMember(MemberRequestDto requestDto) {

        Member member = memberRepository.getMember(memberMapper.toEntity(requestDto)).orElseThrow();
        member.update(requestDto.getName());

        return member;
    }

    /**
     * 삭제
     */
    public Member deleteMember(MemberRequestDto requestDto) {
        return memberRepository.deleteMember(memberMapper.toEntity(requestDto)).orElseThrow();
    }
}