package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.response.DemoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DemoService {

    private final DemoDomainService demoDomainService;

    public DemoResponseDto findById(int id) {
        return demoDomainService.findById(id);
    }

    public DemoResponseDto findByName(String name) {
        return demoDomainService.findByName(name);
    }

}