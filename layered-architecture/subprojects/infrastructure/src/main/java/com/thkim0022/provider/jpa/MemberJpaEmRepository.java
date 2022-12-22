package com.thkim0022.provider.jpa;

import com.thkim0022.data.entity.Member;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MemberJpaEmRepository {

    private EntityManager em;

    /**
     * 사용자 아이디로 사용자 정보 조회
     */
    public Optional<Member> findById(Long userId) {

        String jpql = "" +
            "SELECT *               \n" +
            "FROM MEMBER            \n" +
            "WHERE USERID = :userId \n";

        Query query = em.createNativeQuery(jpql)
            .setParameter("userId", userId);

        List<Member> resultList = query.getResultList();
        Member member;
        if (resultList.isEmpty()) {
            member = null;
        } else {
            member = resultList.get(0);
        };

        return Optional.of(member);
    }

    /**
     * 사용자 이름으로 사용자 정보 조회
     */
    public List<Member> findByUserName(String userName) {

        String jpql = "" +
            "SELECT *                   \n" +
            "FROM MEMBER                \n" +
            "WHERE USERNAME = :userName \n";

        Query query = em.createNativeQuery(jpql)
            .setParameter("userName", userName);

        return query.getResultList();
    }

    public List<Member> findAll() {

        String jpql = "" +
            "SELECT *       \n" +
            "FROM MEMBER    \n";

        Query query = em.createNativeQuery(jpql);

        return query.getResultList();
    }

    /**
     * 사용자 정보 등록
     */
    public void save(Member member) {

        String jpql = "" +
            "INSERT INTO MEMBER \n" +
            "   (USERNAME)      \n" +
            "VAULES (:userName) \n";

        Query query = em.createNativeQuery(jpql)
            .setParameter("userName", member.getUserName());
        query.executeUpdate();
    }

    /**
     * 사용자 정보 수정
     */
    //public Member editMember(Member member) {
    //
    //    String jpql = "" +
    //        "UPDATE MEMBER              \n" +
    //        "SET userName = :userName   \n" +
    //        "WHERE userId = :userId     \n";
    //
    //    Query query = em.createNativeQuery(jpql, Member.class)
    //        .setParameter("userName", member.getUserName())
    //        .setParameter("userId", member.getUserId());
    //    query.executeUpdate();
    //
    //    return member;
    //}

    /**
     * 사용자 정보 삭제
     */
    public void deleteById(Long userId) {

        String jpql = "" +
            "DELETE FROM MEMBER     \n" +
            "WHERE USERID = :userId \n";

        Query query = em.createNativeQuery(jpql)
            .setParameter("userId", userId);
        query.executeUpdate();
    }
}
