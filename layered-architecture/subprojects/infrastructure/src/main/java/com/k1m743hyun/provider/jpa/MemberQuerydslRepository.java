package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.k1m743hyun.data.entity.QMember.member;

@RequiredArgsConstructor
@Repository
public class MemberQuerydslRepository {

    private final JPAQueryFactory queryFactory;

    public Member getMember(Long id) {
        return queryFactory.selectFrom(member).where(member.id);
    }

    public Member saveMember() {

    }

    public Member editMember() {

    }

    public Member deleteMember() {

    }
}
