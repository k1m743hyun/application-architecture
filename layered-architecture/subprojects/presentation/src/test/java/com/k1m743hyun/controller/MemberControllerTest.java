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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    @DisplayName("사용자 아이디를 통한 사용자 정보 조회 테스트")
    @Test
    void getMemberByUserId() throws Exception {

        // given
        Long userId = 1L;

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

    @DisplayName("사용자 이름을 통한 사용자 정보 조회 테스트")
    @Test
    void getMemberByUserName() throws Exception {

        // given
        String userName = "spring";

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

    @DisplayName("사용자 정보 전체 조회 테스트")
    @Test
    void getAllMembers() throws Exception {

        // given
        given(memberService.getAllMembers()).willReturn(List.of(MemberResponseDto.builder().build()));

        // when
        mockMvc.perform(get(URL_TEMPLATE + "/all")
                .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andDo(print());

        // then
        then(memberService).should().getAllMembers();
    }

    @DisplayName("사용자 정보 등록 테스트")
    @Test
    void saveMember() throws Exception {

        // given
        Long userId = 1L;
        String userName = "spring";

        MemberRequestVo requestVo = MemberRequestVo.builder()
            .userId(userId)
            .userName(userName)
            .build();

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

    @DisplayName("사용자 정보 수정 테스트")
    @Test
    void editMember() throws Exception {

        // given
        Long userId = 1L;
        String userName = "spring";

        MemberRequestVo requestVo = MemberRequestVo.builder()
            .userId(userId)
            .userName(userName)
            .build();

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

    @DisplayName("사용자 정보 삭제 테스트")
    @Test
    void deleteMember() throws Exception {

        // given
        Long userId = 1L;

        MemberRequestVo requestVo = MemberRequestVo.builder()
            .userId(userId)
            .build();

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