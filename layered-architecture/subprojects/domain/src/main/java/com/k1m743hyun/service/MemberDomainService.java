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

    public MemberResponseDto getDemo(MemberRequestDto memberRequestDto) {

        if (memberRequestDto.getName() == null) {
            System.out.println("id");
            System.out.println(memberRequestDto.getId());
            System.out.println(memberRequestDto.getName());
            return memberMapper.toDto(memberRepository.findById(memberRequestDto.getId()));
        } else {
            System.out.println("name");
            System.out.println(memberRequestDto.getId());
            System.out.println(memberRequestDto.getName());
            return memberMapper.toDto(memberRepository.findByName(memberRequestDto.getName()));
        }
    }
}