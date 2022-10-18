package com.k1m743hyun.repository;

import com.k1m743hyun.data.entity.Member;
import java.util.Optional;

public interface MemberRepository {

    Optional<Member> getMember(Member member);

    Optional<Member> saveMember(Member member);

    Optional<Member> editMember(Member member);

    Optional<Member> deleteMember(Member member);
}
