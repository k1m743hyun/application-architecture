package com.k1m743hyun.data.mapper;

import com.k1m743hyun.config.ObjectMapperConfig;
import com.k1m743hyun.data.dto.demoRequestDto;
import com.k1m743hyun.data.entity.demo;
import org.mapstruct.Mapper;

@Mapper(config = ObjectMapperConfig.class)
public interface demoMapper {
    demo toDto(demoRequestDto request);
}
