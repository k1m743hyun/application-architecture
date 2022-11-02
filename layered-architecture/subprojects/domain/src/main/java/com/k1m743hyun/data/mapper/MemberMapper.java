package com.k1m743hyun.data.mapper;

import com.k1m743hyun.config.ObjectMapperConfig;
import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.entity.Member;
import org.mapstruct.Mapper;

@Mapper(config = ObjectMapperConfig.class)
public interface MemberMapper {

    Member toEntity(MemberRequestDto requestDto);
    MemberResponseDto toDto(Member request);
}
