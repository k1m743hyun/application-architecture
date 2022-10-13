package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.mapper.MemberMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberDomainService memberDomainService;

    @Mock
    MemberMapper memberMapper;

    //@test
    void whenRequestGetDemo_thenReturnSuccess() throws Exception{
        // given
        Long id = Long.valueOf(1);
        String name = "spring";

        MemberResponseDto memberResponseDto = MemberResponseDto.builder().build();
        //JunitTestUtils.set
    }
}