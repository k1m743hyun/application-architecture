package com.k1m743hyun.controller;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("사용자 관리")
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    private static final String URL_TEMPLATE = "/member";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    @Test
    void getMember() throws Exception {

        given(memberService.getMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        mockMvc.perform(get(URL_TEMPLATE)
                        .accept(MediaType.APPLICATION_JSON)
                        .queryParam("id", "1")
                )
                .andExpect(status().isOk())
                .andDo(print());

        then(memberService).should().getMember(any(MemberRequestDto.class));
    }

    @Test
    void saveMember() throws Exception {

        given(memberService.saveMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        mockMvc.perform(post(URL_TEMPLATE)
                        .accept(MediaType.APPLICATION_JSON)
                        .queryParam("id", "1")
                        .queryParam("name", "spring")
                )
                .andExpect(status().isOk())
                .andDo(print());

        then(memberService).should().saveMember(any(MemberRequestDto.class));
    }

    @Test
    void editMember() throws Exception {

        given(memberService.editMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        mockMvc.perform(put(URL_TEMPLATE)
                        .accept(MediaType.APPLICATION_JSON)
                        .queryParam("id", "1")
                )
                .andExpect(status().isOk())
                .andDo(print());

        then(memberService).should().editMember(any(MemberRequestDto.class));
    }

    @Test
    void deleteMember() throws Exception {

        given(memberService.deleteMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        mockMvc.perform(delete(URL_TEMPLATE)
                        .accept(MediaType.APPLICATION_JSON)
                        .queryParam("id", "1")
                )
                .andExpect(status().isOk())
                .andDo(print());

        then(memberService).should().deleteMember(any(MemberRequestDto.class));
    }
}