package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


class MemberRepositoryImplTest {

    @InjectMocks
    MemberRepositoryImpl memberRepositoryImpl;

    @Mock
    MemberJpaRepository memberJpaRepository;

    @Test
    void getMember() {

        given(memberJpaRepository.findById(anyLong())).willReturn(Optional.of(Member.builder().build()));

        Optional<Member> result = memberRepositoryImpl.getMember(any(Member.class));

        then(memberJpaRepository).should().findById(anyLong());
    }

    @Test
    void saveMember() {

        given(memberJpaRepository.save(any(Member.class)));

        Optional<Member> result = memberRepositoryImpl.saveMember(any(Member.class));

        then(memberJpaRepository).should().save(any(Member.class));
    }

    @Test
    void deleteMember() {

        given(memberJpaRepository.deleteById(anyLong())).willReturn(Optional.of(Member.builder().build()));

        Optional<Member> result = memberRepositoryImpl.deleteMember(any(Member.class));

        then(memberJpaRepository).should().deleteById(anyLong());
    }
}