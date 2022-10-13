package com.k1m743hyun.data.mapper;

import com.k1m743hyun.config.ObjectMapperConfig;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.entity.Member;
import java.util.Optional;
import org.mapstruct.Mapper;

@Mapper(config = ObjectMapperConfig.class)
public interface MemberMapper {

    MemberResponseDto toDto(Optional<Member> request);

    //Demo toEntity(DemoRequestDto requestDto);
}
