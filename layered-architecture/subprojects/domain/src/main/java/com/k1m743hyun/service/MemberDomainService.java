package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import java.util.List;
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
    public Member getMemberByUserId(MemberRequestDto requestDto){

        Member member = memberMapper.toEntity(requestDto);

        return memberRepository.getMemberByUserId(member.getUserId()).orElse(member);
    }

    public Member getMemberByUserName(MemberRequestDto requestDto) {
        Member member = memberMapper.toEntity(requestDto);

        return memberRepository.getMemberByUserName(member.getUserName()).orElse(member);
    }

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

        Member member = memberMapper.toEntity(requestDto);
        Member new_member = memberRepository.getMemberByUserId(member.getUserId()).orElse(member);
        new_member.update(requestDto.getUserName());

        return new_member;
    }

    /**
     * 삭제
     */
    public Member deleteMember(MemberRequestDto requestDto) {

        Member member = memberMapper.toEntity(requestDto);

        memberRepository.deleteMember(member.getUserId());

        return member;
    }
}