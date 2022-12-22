package com.thkim0022.domain.repository;

import com.thkim0022.data.entity.Member;
import com.thkim0022.provider.jpa.MemberJpaEmRepository;
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
    //MemberJpaRepository memberRepository;
    MemberJpaEmRepository memberRepository;

    @InjectMocks
    MemberRepositoryImpl memberRepositoryImpl;

    @DisplayName("사용자 아이디로 사용자 정보 조회")
    @Test
    void getMemberByUserId() {

        // given
        Long userId = anyLong();
        given(memberRepository.findById(userId)).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberRepositoryImpl.getMemberByUserId(userId);

        // then
        then(memberRepository).should().findById(userId);
    }

    @DisplayName("사용자 이름으로 사용자 정보 조회")
    @Test
    void getMemberByUserName() {

        // given
        String userName = anyString();
        given(memberRepository.findByUserName(userName)).willReturn(List.of(Member.builder().build()));

        // when
        List<Member> result = memberRepositoryImpl.getMemberByUserName(userName);

        // then
        then(memberRepository).should().findByUserName(userName);
    }

    @DisplayName("사용자 정보 전체 조회")
    @Test
    void getAllMembers() {

        // given
        given(memberRepository.findAll()).willReturn(List.of(Member.builder().build()));

        // when
        List<Member> result = memberRepositoryImpl.getAllMembers();

        // then
        then(memberRepository).should().findAll();
    }

    @DisplayName("사용자 정보 등록")
    @Test
    void saveMember() {

        // given
        Member member = any(Member.class);

        // when
        memberRepositoryImpl.saveMember(member);

        // then
        then(memberRepository).should().save(member);
    }

    @DisplayName("사용자 정보 삭제")
    @Test
    void deleteMember() {

        // given
        Long userId = anyLong();

        // when
        memberRepositoryImpl.deleteMember(userId);

        // then
        then(memberRepository).should().deleteById(userId);
    }
}