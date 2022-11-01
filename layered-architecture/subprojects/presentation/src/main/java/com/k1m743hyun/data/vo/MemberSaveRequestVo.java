package com.k1m743hyun.data.vo;

import io.swagger.annotations.ApiModelProperty;

public class MemberSaveRequestVo extends MemberRequestVo {

    @ApiModelProperty(hidden = true)
    private Long userId;
}
