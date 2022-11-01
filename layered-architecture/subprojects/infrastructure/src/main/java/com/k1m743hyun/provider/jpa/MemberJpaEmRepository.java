package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class MemberJpaEmRepository {

    private EntityManager em;

    public Member getMember(Long userId) {

        String jpql = "" +
                "SELECT *       \n" +
                "FROM MEMBER    \n" +
                "WHERE id = :userId \n";

        Query query = em.createNativeQuery(jpql, Member.class)
                .setParameter("userId", userId);

        return (Member) query.getSingleResult();
    }

    public Member saveMember(Member member) {

        String jpql = "";

        Query query = em.createNativeQuery(jpql, Member.class);
        query.executeUpdate();

        return member;
    }

    public Member editMember(Member member) {

        String jpql = "";

        Query query = em.createNativeQuery(jpql, Member.class);
        query.executeUpdate();

        return member;
    }

    public Member deleteMember(Long userId) {

        String jpql = "";

        Query query = em.createNativeQuery(jpql, Member.class);
        query.executeUpdate();

        return Member.builder().userId(userId).build();
    }
}
