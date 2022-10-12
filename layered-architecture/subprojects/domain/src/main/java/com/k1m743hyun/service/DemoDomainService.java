package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.request.DemoRequestDto;
import com.k1m743hyun.data.dto.response.DemoResponseDto;
import com.k1m743hyun.data.mapper.DemoMapper;
import com.k1m743hyun.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DemoDomainService {

    private final DemoRepository demoRepository;

    private final DemoMapper demoMapper;

    public DemoResponseDto getDemo(DemoRequestDto demoRequestDto) {

        if (demoRequestDto.getName() == null) {
            System.out.println("id");
            System.out.println(demoRequestDto.getId());
            System.out.println(demoRequestDto.getName());
            return demoMapper.toDto(demoRepository.findById(demoRequestDto.getId()));
        } else {
            System.out.println("name");
            System.out.println(demoRequestDto.getId());
            System.out.println(demoRequestDto.getName());
            return demoMapper.toDto(demoRepository.findByName(demoRequestDto.getName()));
        }
    }
}