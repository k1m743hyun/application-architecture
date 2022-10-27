package com.k1m743hyun.data.mapper;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto;
import com.k1m743hyun.data.dto.response.MemberResponseDto.MemberResponseDtoBuilder;
import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.data.entity.Member.MemberBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-27T23:11:20+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15.1 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toEntity(MemberRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.id( requestDto.getId() );
        member.name( requestDto.getName() );

        return member.build();
    }

    @Override
    public MemberResponseDto toDto(Member request) {
        if ( request == null ) {
            return null;
        }

        MemberResponseDtoBuilder memberResponseDto = MemberResponseDto.builder();

        memberResponseDto.id( request.getId() );
        memberResponseDto.name( request.getName() );

        return memberResponseDto.build();
    }
}
