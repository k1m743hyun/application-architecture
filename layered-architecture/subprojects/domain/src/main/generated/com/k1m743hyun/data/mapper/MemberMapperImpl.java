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
    date = "2022-11-01T13:21:51+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toEntity(MemberRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.userId( requestDto.getUserId() );
        member.userName( requestDto.getUserName() );

        return member.build();
    }

    @Override
    public MemberResponseDto toDto(Member request) {
        if ( request == null ) {
            return null;
        }

        MemberResponseDtoBuilder memberResponseDto = MemberResponseDto.builder();

        memberResponseDto.userId( request.getUserId() );
        memberResponseDto.userName( request.getUserName() );

        return memberResponseDto.build();
    }
}
