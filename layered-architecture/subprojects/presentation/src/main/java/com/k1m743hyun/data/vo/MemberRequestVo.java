package com.k1m743hyun.data.vo;

import com.k1m743hyun.data.dto.request.MemberRequestDto;
import com.k1m743hyun.validation.marker.MemberRequestValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberRequestVo {

    @NotNull(groups = {MemberRequestValidation.getMemberByUserId.class, MemberRequestValidation.getMemberByUserName.class, MemberRequestValidation.editMember.class, MemberRequestValidation.deleteMember.class})
    private Long userId;

    @NotNull(groups = MemberRequestValidation.saveMember.class)
    private String userName;

    public MemberRequestDto convert() {
        return MemberRequestDto.builder()
            .userId(userId)
            .userName(userName)
            .build();
    }
}
