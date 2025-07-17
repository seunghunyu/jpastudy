package com.study.jpastudy.chapter10.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryModifiers;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.study.jpastudy.chapter10.ItemDTO;
import com.study.jpastudy.chapter2.Member;
import static com.study.jpastudy.chapter2.QMember.member;

//import com.study.jpastudy.chapter2.QMember;
import com.study.jpastudy.chapter4_ex.*;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.query.criteria.JpaSubQuery;
import org.springframework.util.StringUtils;

import javax.naming.directory.SearchResult;
import java.math.BigInteger;
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

    //조인
    public void ex10_89(){
        EntityManager em = emf.createEntityManager();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QOrder order = QOrder.order;
        QMember member = QMember.member;
        QOrderItem orderItem = QOrderItem.orderItem;

//        List<?> fetch = queryFactory.from(order)
//                .join(order.member, member)
//                .leftJoin(order.orderItems, orderItem)
//                .fetch();

        //on 절 사용
//        fetch = queryFactory.from(order)
//                .leftJoin(order.orderItems, orderItem)
//                .on(orderItem.count.gt(2))
//                .fetch();

        //페치 조인
//        fetch = queryFactory.from(order)
//                .innerJoin(order.member, member).fetch()
//                .leftJoin(order.orderItems, orderItem).fetch()
//                .fetch();

        //from 절에 여러 조건 사용
//        queryFactory.from(order, member)
//                .where(order.member.eq(member))
//                .fetch();

        QItem item = QItem.item;
        QItem itemSub = new QItem("itemSub");
        //서브쿼리 - 한 건   query dsl 4.x.x
//        query.from(item)
//                .where(item.price.eq(
//                        new com.mysema.query.jpa.JPASubQuery.from(itemSub).unique(itemSub.price.max())
//                ))
//                .fetch();
        queryFactory.from(item)
                .where(item.price.eq(
                        JPAExpressions.select(itemSub.price.max()).from(itemSub)
                ))
                .fetch();

        //서브쿼리 - 여러 건
//        query.from(item) query dsl 4.x.x
//                .where(item.in(
//                        new JPASubQuery().from(itemSub)
//                                .where(item.name.eq(itemSub.name))
//                                .list(itemSub)
//                )).list(itemSub);
        queryFactory.from(item)
                .where(item.in(
                        JPAExpressions
                                .selectFrom(itemSub)
                                .where(item.name.eq(itemSub.name))
                                .fetch()
                )).fetch();
//        엔티티 전체를 조회할 경우	selectFrom()
//        특정 필드만 조회할 경우	select()
//        DTO 매핑이 필요한 경우	select()


         //프로젝션 대상이 하나
         List<String> result = queryFactory.select(item.name).from(item).fetch();
         for(String name : result){
             System.out.println("name = " + name);
         }

         //여러 컬럼 반환과 튜플
         List<Tuple> results = queryFactory.select(item.name,item.price).from(item).fetch();

         for(Tuple tuple : results){
             System.out.println("name = " + tuple.get(item.name));
             System.out.println("price = " + tuple.get(item.price));
         }

         //Projections
         //프로퍼티 접근(Setter)
         //query.from(item).list(Projections.bean(itemDTO.class, item.name.as("username"), item.price)) 4.x.x
         List<ItemDTO> results2 = queryFactory.select(Projections.bean(ItemDTO.class,
                 item.name.as("username"), item.price)).from(item).fetch();

         //필드 직접 접근
         results2 = queryFactory.select(Projections.fields(ItemDTO.class,
                 item.name.as("username"),item.price)).fetch();

         //생성자 사용
         results2 = queryFactory.select(Projections.constructor(ItemDTO.class, item.name, item.price)).fetch();

         //10.4.10 수정,삭제 배치 쿼리
        //수정
        JPAUpdateClause updateClause = new JPAUpdateClause(em, item);
        long count = updateClause.where(item.name.eq("테스트"))
                .set(item.price, item.price.add(100))
                .execute();
        //삭제
        JPAUpdateClause deleteClause = new JPAUpdateClause(em, item);
        count = deleteClause.where(item.name.eq("테스트")).execute();

        //10.4.11 동적 쿼리
        ItemDTO param = new ItemDTO();
        param.setUsername("test");
        param.setPrice(10000);
        BooleanBuilder builder = new BooleanBuilder();
        if(StringUtils.hasText(param.getUsername())) {
            builder.and(item.name.contains(param.getUsername()));
        }
        if(param.getPrice() != 0){
            builder.and(item.price.gt(param.getPrice()));
        }
        List<Item> result3 = queryFactory.selectFrom(item).where(builder).fetch();

        //10.4.12 메소드 위임
//        queryFactory.selectFrom(item).where(item.isExpensive(30000)).fetch();


        //10.5 네이티브 SQL
        //엔티티 조회
        String sql = " SELECT ID, NAME, TEAM_ID FROM MEMBER WHERE AGE > ? ";
        Query nativeQuery = em.createNativeQuery(sql, Member.class)
                .setParameter(1, 20 );

        List<Member> resultList = nativeQuery.getResultList();

        //값 조회
        nativeQuery = em.createNativeQuery(sql) // 엔티티 조회가아닌 여러 값으로 조회 시 두번째에 엔티티인자를 안넘기면 된다.
                .setParameter(1, 20 );
        List<Object[]> resultList2 = nativeQuery.getResultList();
        for(Object[] row : resultList2){
            System.out.println("id = " + row[0]);
            System.out.println("age = " + row[1]);
            System.out.println("name = " + row[2]);
            System.out.println("team_id = " + row[3]);
        }

        //엔티티와 스칼라값을 함게 조회하는 것처럼 매핑잉 복잡해지면 @SqlResultSetMapping을 정의해서 결과 매핑을 사용해야한다.
        sql = " SELECT M.ID, AGE, NAME, TEAM_ID, I.ORDER_COUNT "+
               " FROM MEMBER M " +
               " LEFT JOIN " +
               "  (SELECT IM.ID, COUNT(*) AS ORDER_COUNT " +
                " FROM ORDERS O, MEMBER M " +
                " WHERE O.MEMBER_ID = IM.ID) I " +
                " ON M.ID = I.ID " ;
        /*
         * @Entity
         * @SqlResultMapping(name = "memberWithOrderCount",
         * entities={@EntityResult(entityClass = Member.class)},
         * columns={@ColumnResult(name = "ORDER_COUNT")})
         */
        nativeQuery = em.createNativeQuery(sql, "memberWithOrderCount"); //두번째 파라미터에 결과 매핑정보 이름 사용
        List<Object[]> resultList3 = nativeQuery.getResultList();
        for(Object[] row : resultList3){
            Member member2 = (Member) row[0];
            BigInteger orderCount = (BigInteger) row[1];

            System.out.println("member = " + member);
            System.out.println("orderCount = " + orderCount);

        }





    }






}
