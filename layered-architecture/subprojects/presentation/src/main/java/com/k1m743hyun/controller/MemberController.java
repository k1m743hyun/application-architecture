package com.k1m743hyun.controller;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.vo.MemberRequestVo;
import com.k1m743hyun.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberController {

    private final MemberService memberService;

    @ApiOperation("조회")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "Long", required = false, value = "ID", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = false, value = "Name", example = "spring")
    })
    @GetMapping
    public MemberResponseDto getMember(@ApiIgnore MemberRequestVo requestVo) {

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.getMember(requestDto);
    }

    @PostMapping
    public MemberRequestDto saveMember(MemberRequestVo requestVo) {

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.saveMember(requestDto);
    }

    @PutMapping
    public MemberRequestDto editMember(MemberRequestVo requestVo) {

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.editMember(requestDto);
    }

    @DeleteMapping
    public MemberRequestDto deleteMember(MemberRequestVo requestVo) {

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.deleteMember(requestDto);
    }
}