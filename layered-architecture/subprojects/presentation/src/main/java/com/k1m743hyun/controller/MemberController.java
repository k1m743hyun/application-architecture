package com.k1m743hyun.controller;

import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.vo.MemberRequestVo;
import com.k1m743hyun.service.MemberService;
import com.k1m743hyun.validation.marker.MemberRequestValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "사용자 관리")
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "사용자 아이디로 사용자 정보 조회", notes = "사용자의 ID를 통해 사용자의 정보를 조회한다.")
    @ApiImplicitParam(name = "userId", paramType = "path", dataType = "long", required = true, value = "사용자 ID", example = "1")
    @GetMapping("/userId/{userId}")
    public MemberResponseDto getMemberByUserId(@PathVariable Long userId) {
        return memberService.getMemberByUserId(MemberRequestVo.builder()
            .userId(userId)
            .build()
            .convert());
    }

    @ApiOperation(value = "사용자 이름으로 사용자 정보 조회", notes = "사용자의 이름을 통해 사용자의 정보를 조회한다.")
    @ApiImplicitParam(name = "userName", paramType = "path", dataType = "string", required = true, value = "사용자 이름", example = "spring")
    @GetMapping("/userName/{userName}")
    public List<MemberResponseDto> getMemberByUserName(@PathVariable String userName) {
        return memberService.getMemberByUserName(MemberRequestVo.builder()
            .userName(userName)
            .build()
            .convert());
    }

    @ApiOperation(value = "사용자 정보 전체 조회", notes = "모든 사용자의 정보를 조회한다.")
    @GetMapping("/all")
    public List<MemberResponseDto> getAllMembers() {
        return memberService.getAllMembers();
    }

    @ApiOperation(value = "사용자 정보 등록", notes = "사용자의 ID를 통해 사용자의 정보를 등록한다.")
    @PostMapping("/save")
    public MemberResponseDto saveMember(@RequestBody @Validated(MemberRequestValidation.saveMember.class) MemberRequestVo requestVo) {
        return memberService.saveMember(requestVo.convert());
    }

    @ApiOperation(value = "사용자 정보 수정", notes = "사용자의 ID를 통해 사용자의 정보를 수정한다.")
    @PutMapping("/edit")
    public MemberResponseDto editMember(@RequestBody @Validated(MemberRequestValidation.editMember.class) MemberRequestVo requestVo) {
        return memberService.editMember(requestVo.convert());
    }

    @ApiOperation(value = "사용자 정보 삭제", notes = "사용자의 ID를 통해 사용자의 정보를 삭제한다.")
    @DeleteMapping("/delete")
    public MemberResponseDto deleteMember(@RequestBody @Validated(MemberRequestValidation.deleteMember.class) MemberRequestVo requestVo) {
        return memberService.deleteMember(requestVo.convert());
    }
}