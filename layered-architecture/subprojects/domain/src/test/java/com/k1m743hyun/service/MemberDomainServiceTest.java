package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.mapper.MemberMapper;
import com.k1m743hyun.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
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
        given(memberRepository.getMember(anyLong()));

        // when
        memberDomainService.getMember(any(MemberRequestDto.class));

        // then
        then(memberRepository).should().getMember(anyLong());
    }

    @Test
    void saveMember() {

        // given

        // when
        Member result = memberDomainService.saveMember(any(MemberRequestDto.class));

        // then
        assertThat(result).isEqualTo(memberMapper.toEntity(MemberRequestDto.builder().build()));
    }

    @Test
    void editMember() {

        // given
        given(memberRepository.getMember(anyLong()));

        // when
        Member result = memberDomainService.editMember(any(MemberRequestDto.class));

        // then
        then(memberRepository).should().getMember(anyLong());
        //assertThat(result).isEqualTo(memberMapper.toEntity(MemberRequestDto.builder().build()));
    }

    @Test
    void deleteMember() {

        MemberRequestDto requestDto = MemberRequestDto.builder()
                    .id(anyLong())
                    .build();

        // given

        // when
        Member result = memberDomainService.deleteMember(requestDto);

        // then
        then(memberRepository).should().deleteMember(anyLong());
        //assertThat(result).isEqualTo(memberMapper.toEntity(requestDto));
    }
}