package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberQuerydslRepository {

    //private final JPAQueryFactory queryFactory;

    public Member getMember(Long id) {
        return Member.builder().build();
    }

    public Member saveMember() {
        return Member.builder().build();
    }

    public Member editMember() {
        return Member.builder().build();
    }

    public Member deleteMember() {
        return Member.builder().build();
    }
}
