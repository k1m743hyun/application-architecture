package com.k1m743hyun.data.vo;

import io.swagger.annotations.ApiModelProperty;

public class MemberDeleteRequestVo extends MemberRequestVo {

    @ApiModelProperty(hidden = true)
    private String userName;
}
