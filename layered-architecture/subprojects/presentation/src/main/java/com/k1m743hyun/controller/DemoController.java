package com.k1m743hyun.controller;

import com.k1m743hyun.data.dto.request.DemoRequestDto;
import com.k1m743hyun.data.dto.response.DemoResponseDto;
import com.k1m743hyun.data.vo.DemoRequestVo;
import com.k1m743hyun.service.DemoService;
import com.k1m743hyun.validation.marker.DemoRequestValidation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    private final DemoService demoService;

    @ApiOperation("조회")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "id", paramType = "query", dataType = "Long", required = false, value = "ID", example = "1"),
        @ApiImplicitParam(name = "name", paramType = "query", dataType = "string", required = false, value = "Name", example = "spring")
    })
    @GetMapping
    public DemoResponseDto getDemo(@ApiIgnore DemoRequestVo demoRequestVo) {
        System.out.println(demoRequestVo.getId());
        System.out.println(demoRequestVo.getName());
        DemoRequestDto demoRequestDto = demoRequestVo.convert();
        System.out.println(demoRequestDto.getId());
        System.out.println(demoRequestDto.getName());
        return demoService.getDemo(demoRequestDto);
    }
}