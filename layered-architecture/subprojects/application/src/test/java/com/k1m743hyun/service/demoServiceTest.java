package com.k1m743hyun.service;

import com.k1m743hyun.data.dto.response.DemoResponseDto;
import com.k1m743hyun.data.mapper.DemoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DemoServiceTest {

    @InjectMocks
    DemoService demoService;

    @Mock
    DemoDomainService demoDomainService;

    @Mock
    DemoMapper demoMapper;

    //@test
    void whenRequestGetDemo_thenReturnSuccess() throws Exception{
        // given
        Long id = Long.valueOf(1);
        String name = "spring";

        DemoResponseDto demoResponseDto = DemoResponseDto.builder().build();
        //JunitTestUtils.set
    }
}