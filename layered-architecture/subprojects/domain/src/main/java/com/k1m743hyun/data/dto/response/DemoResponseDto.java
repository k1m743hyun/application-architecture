package com.k1m743hyun.data.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class DemoResponseDto {

    private int id;
    private String name;
}
