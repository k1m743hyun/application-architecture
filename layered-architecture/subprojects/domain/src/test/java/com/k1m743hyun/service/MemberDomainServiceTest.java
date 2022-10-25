package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


class MemberDomainServiceTest {

    @InjectMocks
    MemberDomainService memberDomainService;

    @Mock
    MemberRepository memberRepository;

    @Mock
    MemberMapper memberMapper;

    @Test
    void getMember() {

        // given
        given(memberRepository.getMember(any(Member.class))).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberDomainService.getMember(MemberRequestDto.builder().build());

        // then
        then(memberRepository).should().getMember(any(Member.class));
    }

    @Test
    void saveMember() {

        // given
        //given(memberRepository.saveMember(any(Member.class))).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberDomainService.saveMember(MemberRequestDto.builder().build());

        // then
        then(memberRepository).should().saveMember(any(Member.class));
    }

    @Test
    void editMember() {

        // given
        given(memberRepository.getMember(any(Member.class))).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberDomainService.editMember(MemberRequestDto.builder().build());

        // then
        then(memberRepository).should().getMember(any(Member.class));
    }

    @Test
    void deleteMember() {

        // given
        //given(memberRepository.deleteMember(any(Member.class))).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberDomainService.deleteMember(MemberRequestDto.builder().build());

        // then
        then(memberRepository).should().deleteMember(any(Member.class));
    }
}