package com.k1m743hyun.provider.jpa;

import com.k1m743hyun.data.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class MemberJpaEmRepository {

    private EntityManager em;

    public Member getMember(Long id) {

        String jpql = "" +
                "SELECT *       \n" +
                "FROM MEMBER    \n" +
                "WHERE id = :id \n";

        Query query = em.createNativeQuery(jpql, Member.class)
                .setParameter("id", id);

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

    public Member deleteMember(Long id) {

        String jpql = "";

        Query query = em.createNativeQuery(jpql, Member.class);
        query.executeUpdate();

        return Member.builder().id(id).build();
    }
}
