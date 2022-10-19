package com.k1m743hyun.data.vo;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.validation.marker.MemberRequestValidation;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MemberRequestVo {

    @NotNull(groups = {MemberRequestValidation.get.class, MemberRequestValidation.save.class, MemberRequestValidation.edit.class, MemberRequestValidation.delete.class})
    private Long id;

    @NotNull(groups = MemberRequestValidation.save.class)
    private String name;

    public MemberRequestDto convert() {
        return MemberRequestDto.builder()
            .id(id)
            .name(name)
            .build();
    }
}
