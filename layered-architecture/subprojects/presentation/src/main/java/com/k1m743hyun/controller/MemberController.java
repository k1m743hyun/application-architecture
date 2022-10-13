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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberController {

    private final MemberService memberService;

    @ApiOperation("조회")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "Long", required = false, value = "ID", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = false, value = "Name", example = "spring")
    })
    @GetMapping
    public MemberResponseDto getDemo(@ApiIgnore MemberRequestVo memberRequestVo) {
        System.out.println(memberRequestVo.getId());
        System.out.println(memberRequestVo.getName());
        MemberRequestDto memberRequestDto = memberRequestVo.convert();
        System.out.println(memberRequestDto.getId());
        System.out.println(memberRequestDto.getName());
        return memberService.getDemo(memberRequestDto);
    }
}