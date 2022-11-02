package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import java.util.List;
import java.util.NoSuchElementException;
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
     * 상세 조회
     */
    public Member getMemberByUserId(MemberRequestDto requestDto){
        return memberRepository.getMemberByUserId(requestDto.getUserId()).orElseThrow(() -> new NoSuchElementException());
    }

    public List<Member> getMemberByUserName(MemberRequestDto requestDto) {

        return memberRepository.getMemberByUserName(requestDto.getUserName());
    }

    /**
     * 리스트 조회
     */
    public List<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    /**
     * 등록
     */
    public Member saveMember(MemberRequestDto requestDto) {

        Member member = memberMapper.toEntity(requestDto);

        memberRepository.saveMember(member);

        return member;
    }

    /**
     * 수정
     */
    public Member editMember(MemberRequestDto requestDto) {

        Member member = memberRepository.getMemberByUserId(requestDto.getUserId()).orElseThrow(() -> new NoSuchElementException());

        member.update(requestDto.getUserName());

        return member;
    }

    /**
     * 삭제
     */
    public Member deleteMember(MemberRequestDto requestDto) {

        Member member = memberRepository.getMemberByUserId(requestDto.getUserId()).orElse(Member.builder().build());

        memberRepository.deleteMember(requestDto.getUserId());

        return member;
    }
}