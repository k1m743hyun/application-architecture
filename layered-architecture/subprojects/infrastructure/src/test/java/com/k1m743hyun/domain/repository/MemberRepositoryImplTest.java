package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class MemberRepositoryImplTest {

    @Mock
    MemberJpaRepository memberJpaRepository;

    @InjectMocks
    MemberRepositoryImpl memberRepository;

    @DisplayName("사용자 아이디로 사용자 정보 조회")
    @Test
    void getMemberByUserId() {

        // given
        Long userId = anyLong();
        given(memberJpaRepository.findById(userId)).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberRepository.getMemberByUserId(userId);

        // then
        then(memberJpaRepository).should().findById(userId);
    }

    @DisplayName("사용자 이름으로 사용자 정보 조회")
    @Test
    void getMemberByUserName() {

        // given
        String userName = anyString();
        given(memberJpaRepository.findByUserName(userName)).willReturn(List.of(Member.builder().build()));

        // when
        List<Member> result = memberRepository.getMemberByUserName(userName);

        // then
        then(memberJpaRepository).should().findByUserName(userName);
    }

    @DisplayName("사용자 정보 전체 조회")
    @Test
    void getAllMembers() {

        // given
        given(memberJpaRepository.findAll()).willReturn(List.of(Member.builder().build()));

        // when
        List<Member> result = memberRepository.getAllMembers();

        // then
        then(memberJpaRepository).should().findAll();
    }

    @DisplayName("사용자 정보 등록")
    @Test
    void saveMember() {

        // given
        Member member = any(Member.class);

        // when
        memberRepository.saveMember(member);

        // then
        then(memberJpaRepository).should().save(member);
    }

    @DisplayName("사용자 정보 삭제")
    @Test
    void deleteMember() {

        // given
        Long userId = anyLong();

        // when
        memberRepository.deleteMember(userId);

        // then
        then(memberJpaRepository).should().deleteById(userId);
    }
}