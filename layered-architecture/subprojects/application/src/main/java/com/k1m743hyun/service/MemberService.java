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

    public MemberResponseDto getDemo(MemberRequestDto memberRequestDto) {
        return memberDomainService.getDemo(memberRequestDto);
    }
}