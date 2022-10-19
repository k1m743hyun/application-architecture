package com.k1m743hyun.controller;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.vo.MemberRequestVo;
import com.k1m743hyun.service.MemberService;
import com.k1m743hyun.validation.marker.MemberRequestValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "사용자 관리")
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "사용자 정보 조회", notes = "사용자의 ID를 통해 사용자의 정보를 조회한다.")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "long", required = true, value = "사용자 아이디", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = false, value = "사용자 이름", example = "spring")
    })
    @GetMapping
    public MemberResponseDto getMember(@ApiIgnore @Validated(MemberRequestValidation.get.class) MemberRequestVo requestVo) {

        log.debug("{} - {}", this.getClass().getSimpleName(), "getMember");

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.getMember(requestDto);
    }

    @ApiOperation(value = "사용자 정보 등록", notes = "사용자의 ID를 통해 사용자의 정보를 등록한다.")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "long", required = true, value = "사용자 아이디", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = true, value = "사용자 이름", example = "spring")
    })
    @PostMapping
    public MemberResponseDto saveMember(@ApiIgnore @Validated(MemberRequestValidation.save.class) MemberRequestVo requestVo) {

        log.debug("{} - {}", this.getClass().getSimpleName(), "saveMember");

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.saveMember(requestDto);
    }

    @ApiOperation(value = "사용자 정보 수정", notes = "사용자의 ID를 통해 사용자의 정보를 수정한다.")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "long", required = true, value = "사용자 아이디", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = false, value = "사용자 이름", example = "spring")
    })
    @PutMapping
    public MemberResponseDto editMember(@ApiIgnore @Validated(MemberRequestValidation.edit.class) MemberRequestVo requestVo) {

        log.debug("{} - {}", this.getClass().getSimpleName(), "editMember");

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.editMember(requestDto);
    }

    @ApiOperation(value = "사용자 정보 삭제", notes = "사용자의 ID를 통해 사용자의 정보를 삭제한다.")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "long", required = true, value = "사용자 아이디", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = false, value = "사용자 이름", example = "spring")
    })
    @DeleteMapping
    public MemberResponseDto deleteMember(@ApiIgnore @Validated(MemberRequestValidation.delete.class) MemberRequestVo requestVo) {

        log.debug("{} - {}", this.getClass().getSimpleName(), "deleteMember");

        MemberRequestDto requestDto = requestVo.convert();

        return memberService.deleteMember(requestDto);
    }
}