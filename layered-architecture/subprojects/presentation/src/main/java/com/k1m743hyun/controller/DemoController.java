package com.k1m743hyun.controller;

import com.k1m743hyun.data.dto.response.DemoResponseDto;
import com.k1m743hyun.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    public DemoResponseDto findById(int id) {
        return demoService.findById(id);
    }

    public DemoResponseDto findByName(String name) {
        return demoService.findByName(name);
    }
}