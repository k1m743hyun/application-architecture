package com.k1m743hyun.data.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DemoRequestDto {

    private Long id;
    private String name;
}