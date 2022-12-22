package com.thkim0022.data.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberResponseDto {

    private Long userId;
    private String userName;
}
