package com.k1m743hyun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.vo.MemberRequestVo;
import com.k1m743hyun.service.MemberService;
import java.util.List;
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

    private static String URL_TEMPLATE = "/member";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getMemberByUserId() throws Exception {

        Long userId = 1L;

        // given
        given(memberService.getMemberByUserId(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        // when
        mockMvc.perform(get(URL_TEMPLATE + "/userId/" + userId)
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().getMemberByUserId(any(MemberRequestDto.class));
    }

    @Test
    void getMemberByUserName() throws Exception {

        String userName = "spring";

        // given
        given(memberService.getMemberByUserName(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        // when
        mockMvc.perform(get(URL_TEMPLATE + "/userName/" + userName)
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().getMemberByUserName(any(MemberRequestDto.class));
    }

    @Test
    void getAllMembers() throws Exception {

        // given
        given(memberService.getAllMembers()).willReturn(List.of());

        // when
        mockMvc.perform(get(URL_TEMPLATE + "/all")
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().getAllMembers();
    }

    @Test
    void saveMember() throws Exception {

        Long userId = 1L;
        String userName = "spring";

        MemberRequestVo requestVo = MemberRequestVo.builder()
            .userId(userId)
            .userName(userName)
            .build();

        // given
        given(memberService.saveMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        // when
        mockMvc.perform(post(URL_TEMPLATE + "/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(requestVo))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().saveMember(any(MemberRequestDto.class));
    }

    @Test
    void editMember() throws Exception {

        Long userId = 1L;
        String userName = "spring";

        MemberRequestVo requestVo = MemberRequestVo.builder()
            .userId(userId)
            .userName(userName)
            .build();

        // given
        given(memberService.editMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        // when
        mockMvc.perform(put(URL_TEMPLATE + "/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(requestVo))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().editMember(any(MemberRequestDto.class));
    }

    @Test
    void deleteMember() throws Exception {

        Long userId = 1L;

        MemberRequestVo requestVo = MemberRequestVo.builder()
            .userId(userId)
            .build();

        // given
        given(memberService.deleteMember(any(MemberRequestDto.class))).willReturn(MemberResponseDto.builder().build());

        // when
        mockMvc.perform(delete(URL_TEMPLATE + "/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(requestVo))
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().deleteMember(any(MemberRequestDto.class));
    }
}