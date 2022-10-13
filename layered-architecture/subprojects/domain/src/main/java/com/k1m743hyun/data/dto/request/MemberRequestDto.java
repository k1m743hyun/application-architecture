package com.k1m743hyun.data.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberRequestDto {

    private Long id;
    private String name;
}
