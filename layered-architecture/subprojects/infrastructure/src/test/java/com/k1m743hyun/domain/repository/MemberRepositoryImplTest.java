package com.k1m743hyun.domain.repository;

import com.k1m743hyun.data.entity.Member;
import com.k1m743hyun.provider.jpa.MemberJpaRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class MemberRepositoryImplTest {

    @InjectMocks
    MemberRepositoryImpl memberRepository;

    @Mock
    MemberJpaRepository memberJpaRepository;

    @Test
    void getMember() {

        given(memberJpaRepository.findById(anyLong())).willReturn(Optional.of(Member.builder().build()));

        Optional<Member> result = memberRepository.getMember(anyLong());

        then(memberJpaRepository).should().findById(anyLong());
    }

    @Test
    void saveMember() {

        Long id = 1L;
        String name = "spring";

        Member member = Member.builder()
                    .id(id)
                    .name(name)
                    .build();

        memberRepository.saveMember(member);

        then(memberJpaRepository).should().save(member);
    }

    @Test
    void deleteMember() {

        memberRepository.deleteMember(anyLong());

        then(memberJpaRepository).should().deleteById(anyLong());
    }
}