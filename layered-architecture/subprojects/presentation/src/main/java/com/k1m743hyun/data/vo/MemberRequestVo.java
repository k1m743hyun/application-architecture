package com.k1m743hyun.data.vo;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequestVo {

    //@NotNull(groups = DemoRequestValidation.findById.class)
    private Long id;

    //@NotNull(groups = DemoRequestValidation.findByName.class)
    private String name;

    public MemberRequestDto convert() {
        return MemberRequestDto.builder()
            .id(id)
            .name(name)
            .build();
    }
}
