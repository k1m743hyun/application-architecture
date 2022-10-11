package com.k1m743hyun.service;

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

    public DemoResponseDto findById(int id) {
        return demoMapper.toDto(demoRepository.findById(id));
    }

    public DemoResponseDto findByName(String name) {
        return demoMapper.toDto(demoRepository.findByName(name));
    }
}