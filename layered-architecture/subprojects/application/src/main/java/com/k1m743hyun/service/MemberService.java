package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberDomainService memberDomainService;

    public MemberResponseDto getMember(MemberRequestDto requestDto) {
        return memberDomainService.getMember(requestDto);
    }

    public MemberResponseDto saveMember(MemberRequestDto requestDto) {
        return memberDomainService.saveMember(requestDto);
    }

    public MemberResponseDto editMember(MemberRequestDto requestDto) {
        return memberDomainService.editMember(requestDto);
    }

    public MemberResponseDto deleteMember(MemberRequestDto requestDto) {
        return memberDomainService.deleteMember(requestDto);
    }
}