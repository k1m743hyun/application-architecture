package com.k1m743hyun.data.vo;

import com.k1m743hyun.data.dto.request.DemoRequestDto;
import com.k1m743hyun.validation.marker.DemoRequestValidation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoRequestVo {

    //@NotNull(groups = DemoRequestValidation.findById.class)
    private Long id;

    //@NotNull(groups = DemoRequestValidation.findByName.class)
    private String name;

    public DemoRequestDto convert() {
        return DemoRequestDto.builder()
            .id(id)
            .name(name)
            .build();
    }
}
