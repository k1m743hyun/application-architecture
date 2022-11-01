package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberDomainService memberDomainService;

    @Mock
    MemberMapper memberMapper;

    @Test
    void getMemberByUserId() {

        // given
        given(memberDomainService.getMemberByUserId(any(MemberRequestDto.class))).willReturn(Member.builder().build());

        // when
        MemberResponseDto result = memberService.getMemberByUserId(MemberRequestDto.builder().build());

        // then
        then(memberDomainService).should().getMemberByUserId(any(MemberRequestDto.class));
    }

    @Test
    void getMemberByUserName() {

        // given
        given(memberDomainService.getMemberByUserName(any(MemberRequestDto.class))).willReturn(Member.builder().build());

        // when
        MemberResponseDto result = memberService.getMemberByUserName(MemberRequestDto.builder().build());

        // then
        then(memberDomainService).should().getMemberByUserName(any(MemberRequestDto.class));
    }

    @Test
    void getAllMembers() {

        // given
        given(memberDomainService.getAllMembers()).willReturn(List.of());

        // when
        List<MemberResponseDto> result = memberService.getAllMembers();

        // then
        then(memberDomainService).should().getAllMembers();
    }

    @Test
    void saveMember() {

        // given
        given(memberDomainService.saveMember(any(MemberRequestDto.class))).willReturn(Member.builder().build());

        // when
        MemberResponseDto result = memberService.saveMember(MemberRequestDto.builder().build());

        // then
        then(memberDomainService).should().saveMember(any(MemberRequestDto.class));
    }

    @Test
    void editMember() {

        // given
        given(memberDomainService.editMember(any(MemberRequestDto.class))).willReturn(Member.builder().build());

        // when
        MemberResponseDto result = memberService.editMember(MemberRequestDto.builder().build());

        // then
        then(memberDomainService).should().editMember(any(MemberRequestDto.class));
    }

    @Test
    void deleteMember() {

        // given
        given(memberDomainService.deleteMember(any(MemberRequestDto.class))).willReturn(Member.builder().build());

        // when
        MemberResponseDto result = memberService.deleteMember(MemberRequestDto.builder().build());

        // then
        then(memberDomainService).should().deleteMember(any(MemberRequestDto.class));
    }
}