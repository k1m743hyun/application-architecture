package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
class MemberDomainServiceTest {

    @Mock
    MemberRepository memberRepository;

    @Mock
    MemberMapper memberMapper;

    @InjectMocks
    MemberDomainService memberDomainService;

    @Test
    void getMemberByUserId() {

        // given
        Long userId = anyLong();

        given(memberRepository.getMemberByUserId(userId)).willReturn(Optional.of(Member.builder().build()));

        // when
        memberDomainService.getMemberByUserId(MemberRequestDto.builder().userId(userId).build());

        // then
        then(memberRepository).should().getMemberByUserId(userId);
    }

    @Test
    void getMemberByUserName() {

        // given
        String userName = anyString();

        given(memberRepository.getMemberByUserName(userName)).willReturn(List.of(Member.builder().build()));

        // when
        List<Member> result = memberDomainService.getMemberByUserName(MemberRequestDto.builder().userName(userName).build());

        // then
        then(memberRepository).should().getMemberByUserName(userName);
    }

    @Test
    void getAllMembers() {

        // given

        // when
        List<Member> result = memberDomainService.getAllMembers();

        // then
        then(memberRepository).should().getAllMembers();
    }

    @Test
    void saveMember() {

        // given
        String userName = anyString();

        MemberRequestDto requestDto = MemberRequestDto.builder()
            .userName(userName)
            .build();

        Member member = memberMapper.toEntity(requestDto);

        // when
        Member result = memberDomainService.saveMember(requestDto);

        // then
        then(memberRepository).should().saveMember(member);
    }

    @Test
    void editMember() {

        // given
        Long userId = anyLong();

        MemberRequestDto requestDto = MemberRequestDto.builder()
            .userId(userId)
            .build();

        given(memberRepository.getMemberByUserId(userId)).willReturn(Optional.of(Member.builder().build()));

        // when
        Member result = memberDomainService.editMember(requestDto);

        // then
        then(memberRepository).should().getMemberByUserId(userId);
    }

    @Test
    void deleteMember() {

        // given
        Long userId = anyLong();

        // when
        memberDomainService.deleteMember(MemberRequestDto.builder().userId(userId).build());

        // then
        then(memberRepository).should().deleteMember(userId);
    }
}