package com.k1m743hyun.data.mapper;

import com.k1m743hyun.config.ObjectMapperConfig;
import com.k1m743hyun.data.dto.request.DemoRequestDto;
import com.k1m743hyun.data.dto.response.DemoResponseDto;
import com.k1m743hyun.data.entity.Demo;
import java.util.Optional;
import org.mapstruct.Mapper;

@Mapper(config = ObjectMapperConfig.class)
public interface DemoMapper {
    DemoResponseDto toDto(Optional<Demo> request);
}
