package com.study.jpastudy.chapter10.querydsl;

import com.querydsl.core.QueryModifiers;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.jpastudy.chapter2.Member;
import static com.study.jpastudy.chapter2.QMember.member;

//import com.study.jpastudy.chapter2.QMember;
import com.study.jpastudy.chapter4_ex.Item;
import com.study.jpastudy.chapter4_ex.QItem;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.EntityManager;

import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.Optional;

public class Example {
    EntityManagerFactory emf;
    public void queryDSL(){
        EntityManager em = emf.createEntityManager();
//        JPAQuery query = new JPAQuery(em);
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);


//        QMember qMember = new QMember("m"); //생성되는 JPQL의 명칭이 m
////        List<Member> members = queryFactory.from(qMember)
////                .where(qMember.username.eq("회원1"))
////                .orderBy(qMember.username.desc())
////                .list(qMember);
//
//        List<Member> members = queryFactory
//                .selectFrom(qMember)
//                .where(qMember.username.eq("회원1"))
//                .orderBy(qMember.username.desc())
//                .fetch();
    }

    //import static 사용
//import static com.study.jpastudy.chapter2.QMember.member;
    public void queryDSL2(){
        EntityManager em = emf.createEntityManager();
//        JPAQuery query = new JPAQuery(em);
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<Member> members = queryFactory
                .selectFrom(member)
                .where(member.username.eq("회원1"))
                .orderBy(member.username.desc())
                .fetch();
    }
    public void ex10_83(){
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem item = QItem.item;
        List<Item> list= queryFactory.selectFrom(item)
                .where(item.name.eq("좋은상품").and(item.price.gt(20000)))
                .fetch();
        /**
         * JPQL
         * select item
         *  from Item item
         *  where item.name = ?1 and item.price >?2
         */
    }

    //페이징 정렬
    public void ex10_85(){
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem item = QItem.item;

        queryFactory.from(item)
                .where(item.price.gt(20000))
                .orderBy(item.price.desc(), item.stockQuantity.asc())
                .offset(10).limit(20)
                .fetch();
    }
    //QueryModifiers 사용
    public void ex10_86(){
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QueryModifiers queryModifiers = new QueryModifiers(20L, 10L); //limit , offset
        QItem item = QItem.item;
        List<Item> list = queryFactory.selectFrom(item).restrict(queryModifiers).fetch();

//        SearchResults = queryFactory.selectFrom(item).restrict(queryModifiers).fetch(); 없어짐
        Long totalCount = queryFactory
                .select(item.count())
                .from(item)
                .fetchOne(); //fetchOne은 Nullable이라 null 체크를 항상 해야함.
        long total = totalCount != null ? totalCount : 0L;
        //or
        total = Optional.ofNullable(queryFactory.select(item.count()).from(item).fetchOne()).orElse(0L);

        //group by
        List<Item> list2 = queryFactory.selectFrom(item)
                .groupBy(item.price)
                .having(item.price.gt(10000))
                .fetch();


    }




}
