package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class MemberRepositoryImplTest {

    @InjectMocks
    MemberRepositoryImpl memberRepository;

    @Mock
    MemberJpaRepository memberJpaRepository;

    @Test
    void getMemberByUserId() {

        // given
        given(memberJpaRepository.findById(anyLong())).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberRepository.getMemberByUserId(anyLong());

        // then
        then(memberJpaRepository).should().findById(anyLong());
    }

    @Test
    void getMemberByUserName() {

        // given
        given(memberJpaRepository.findByUserName(anyString())).willReturn(Optional.of(Member.builder().build()));

        // when
        Optional<Member> result = memberRepository.getMemberByUserName(anyString());

        // then
        then(memberJpaRepository).should().findByUserName(anyString());
    }

    @Test
    void getAllMembers() {

        // given

        // when
        List<Member> result = memberRepository.getAllMembers();

        // then
        then(memberJpaRepository).should().findAll();
    }

    @Test
    void saveMember() {

        Long userId = 1L;
        String userName = "spring";

        Member member = Member.builder()
                    .userId(userId)
                    .userName(userName)
                    .build();

        // given

        // when
        memberRepository.saveMember(member);

        // then
        then(memberJpaRepository).should().save(member);
    }

    @Test
    void deleteMember() {

        // given

        // when
        memberRepository.deleteMember(anyLong());

        // then
        then(memberJpaRepository).should().deleteById(anyLong());
    }
}