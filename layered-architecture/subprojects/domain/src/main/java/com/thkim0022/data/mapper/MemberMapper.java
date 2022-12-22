package com.thkim0022.data.mapper;

import com.thkim0022.config.ObjectMapperConfig;
import com.thkim0022.data.dto.request.MemberRequestDto;
import com.thkim0022.data.dto.response.MemberResponseDto;
import com.thkim0022.data.entity.Member;
import org.mapstruct.Mapper;

@Mapper(config = ObjectMapperConfig.class)
public interface MemberMapper {

    Member toEntity(MemberRequestDto requestDto);
    MemberResponseDto toDto(Member request);
}
