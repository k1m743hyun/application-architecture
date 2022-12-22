package com.thkim0022.service;

import com.thkim0022.data.dto.request.MemberRequestDto;
import com.thkim0022.data.dto.response.MemberResponseDto;
import com.thkim0022.data.mapper.MemberMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberDomainService memberDomainService;
    private final MemberMapper memberMapper;

    public MemberResponseDto getMemberByUserId(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberDomainService.getMemberByUserId(requestDto));
    }

    public List<MemberResponseDto> getMemberByUserName(MemberRequestDto requestDto) {
        return memberDomainService.getMemberByUserName(requestDto)
            .stream()
            .map(memberMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<MemberResponseDto> getAllMembers() {
        return memberDomainService.getAllMembers()
            .stream()
            .map(memberMapper::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public MemberResponseDto saveMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberDomainService.saveMember(requestDto));
    }

    @Transactional
    public MemberResponseDto editMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberDomainService.editMember(requestDto));
    }

    @Transactional
    public MemberResponseDto deleteMember(MemberRequestDto requestDto) {
        return memberMapper.toDto(memberDomainService.deleteMember(requestDto));
    }
}