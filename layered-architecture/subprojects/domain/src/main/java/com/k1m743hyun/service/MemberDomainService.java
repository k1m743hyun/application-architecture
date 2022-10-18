package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberDomainService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberResponseDto getMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberRepository.getMember(memberMapper.toEntity(requestDto)));
    }

    public MemberResponseDto saveMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberRepository.saveMember(memberMapper.toEntity(requestDto)));
    }

    public MemberResponseDto editMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberRepository.editMember(memberMapper.toEntity(requestDto)));
    }

    public MemberResponseDto deleteMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberRepository.deleteMember(memberMapper.toEntity(requestDto)));
    }
}