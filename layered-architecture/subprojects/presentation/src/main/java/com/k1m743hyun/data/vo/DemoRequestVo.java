package com.k1m743hyun.data.vo;

import com.k1m743hyun.validation.marker.DemoRequestValidation;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoRequestVo {

    @NotNull(groups = DemoRequestValidation.findById.class)
    private int id;

    @NotNull(groups = DemoRequestValidation.findByName.class)
    private String name;
}
