package com.study.jpastudy.chapter10.ex10_54;

import com.study.jpastudy.chapter1.data1.Team;
import com.study.jpastudy.chapter10.Member;
import com.study.jpastudy.chapter10.MemberDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class ex10_54 {
    EntityManager em;
    public void execCriteriaQry(){
        //JPQL: select m from Member m where m.username = '회원1' order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();

        //Criteria 생성, 반환 타입 지정
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class); // FROM 절

        //검색 조건 정의
        Predicate usernameEqual = cb.equal(m.get("username"), "회원1");

        //정렬 조건 정의
        jakarta.persistence.criteria.Order ageDesc = cb.desc(m.get("age"));

        cq.select(m) // SELECT 절
                .where(usernameEqual)
                .orderBy(ageDesc);

        TypedQuery<Member> query = em.createQuery(cq);
        List<Member> members = query.getResultList();
    }

    public void ex10_55(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));
    }
    public void ex10_57(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        //위에서 Member를 타입으로 지정했으므로 지정하지 않아도 Member 타입을 반환
        List<Member> resultList= em.createQuery(cq).getResultList();

    }
    //Object로 조회
    public void ex10_58(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object> cq = cb.createQuery();
        Root<Member> m = cq.from(Member.class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        List<Object> resultList = em.createQuery(cq).getResultList();
    }
    //Object[]로 조회
    public void ex10_59(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Object[]> m = cq.from(Object[].class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        List<Object[]> resultList = em.createQuery(cq).getResultList();
    }
    //튜플로 조회
    public void ex10_60(){
        //select m from Memeber m where m.age > 10 order by m.age desc
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Object[]> m = cq.from(Object[].class);

        //Predicate ageGt = cb.greaterThan(m.<Integer>get("age"),10);
        Predicate ageGt = cb.gt(m.<Integer>get("age"),10);

        cq.select(m);
        cq.where(ageGt);
        cq.orderBy(cb.desc(m.get("age")));

        List<Object[]> resultList = em.createQuery(cq).getResultList();
    }
    //Select
    public void ex10_62(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member> m = cq.from(Member.class);
        cq.multiselect(m.get("username"),m.get("age")).distinct(true);
        //cq.select(cb.array(m.get("username"),m.get("age"))).distinct(true); //위 코드와 동일
        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();
    }
    //JPQL: select new jpabook.domain.MemberDTO(m.username, m.age) from Member m
    public void ex10_63(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MemberDTO> cq = cb.createQuery(MemberDTO.class);
        Root<Member> m = cq.from(Member.class);
        cq.select(cb.construct(MemberDTO.class, m.get("username"),m.get("age")));

        TypedQuery<MemberDTO> query = em.createQuery(cq);
        List<MemberDTO> resultList = query.getResultList();
    }
    //JPQL:  select m.username, m.age from Member m

    /**
     * 1.튜플은 튜플의 검색 키로 사용할 튜플 전용 별칭을 필수로 할당해야한다. 별칭은 alias() 메소드를 사용해서 지정
     * 2.선언해둔 튜플 별칭으로 데이터를 조회할 수 있다.
     * 튜플은 이름 기반이므로 순서 기반의 Object[]보다 안전하다. 그리고 tuple.getElements() 같은 메소드를 사용해서 현재 튜플의
     * 별칭과 자바 타입도 조회할 수 있다.
     * 튜플에 별칭을 준다고 해서 실제 SQL에 별칭이 달리는 것은 아니다. 튜플은 Map과 비슷한 구조여서 별칭을 키로 사용한다.
     *
     */
    public void ex10_64(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        //CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class); //위와 동일
        Root<Member> m = cq.from(Member.class);
        cq.multiselect(
            m.get("username").alias("username"),
            m.get("age").alias("age")
        );
        TypedQuery<Tuple> query = em.createQuery(cq);
        List<Tuple> resultList = query.getResultList();
        for(Tuple tuple : resultList){
            String username = tuple.get("username", String.class);
            Integer age = tuple.get("age", Integer.class);
        }
    }
    //cq.multiselect(...) = cq.select(cb.tuple(...))
    public void ex10_65(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        //CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class); //위와 동일
        Root<Member> m = cq.from(Member.class);
        cq.select(cb.tuple(
                m.alias("m"),
                         m.get("username").alias("username")
                )
        );
        TypedQuery<Tuple> query = em.createQuery(cq);
        List<Tuple> resultList = query.getResultList();
        for(Tuple tuple : resultList){
            Member member = tuple.get("m", Member.class);
            String username = tuple.get("username", String.class);
        }
    }
    //GROUP BY
    public void ex10_66(){
        /**
         * JPQL :select m.team.name, max(m.age), min(m.age)
         *          from Member m
         *         group by m.team.name
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member> m = cq.from(Member.class);

        Expression maxAge = cb.max(m.<Integer>get("age"));
        Expression minAge = cb.max(m.<Integer>get("age"));

        cq.multiselect(m.get("team").get("name"), maxAge, minAge);
        cq.groupBy(m.get("team").get("name"))// group by
                .having(cb.gt(minAge, 10)) //having
                .orderBy(cb.desc(m.get("team").get("name"))); //정렬

        TypedQuery<Object[]> query = em.createQuery(cq);
        List<Object[]> resultList = query.getResultList();
    }
    //JOIN
    public void ex10_67() {
        /**
         *  JPQL
         *  select m, t from Member m
         *   inner join m.team t
         *   where t.name = '팀A'
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member> m = cq.from(Member.class);
        Join<Member, Team> t = m.join("team", JoinType.INNER);

        cq.multiselect(m,t)
                .where(cb.equal(t.get("name"),"팀A"));

    }

    //Sub Query
    public void ex10_68(){
        /**
         *  JPQL
         *  select m from Member m where m.age >= (select AVG(m2.age from Member m2)
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        //서브쿼리 생성
        Subquery<Double> subQuery = mainQuery.subquery(Double.class);
        Root<Member> m2 = subQuery.from(Member.class);
        subQuery.select(cb.avg(m2.<Integer>get("age")));

        //메인 쿼리 생성
        Root<Member> m = mainQuery.from(Member.class);
        mainQuery.select(m).where(cb.ge(m.<Integer>get("age"), subQuery));

    }

    //상호 관련 서브 쿼리
    public void ex10_69(){
        /**
         * JPQL
         *  select m from Member m
         *  where exists (select t from m.team t where t.name = '팀A' )
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        //서브 쿼리에서 사용되는 메인쿼리의 m
        Root<Member> m = mainQuery.from(Member.class);

        //서브 쿼리 생성
        Subquery<Team> subQuery = mainQuery.subquery(Team.class);
        Root<Member> subM = subQuery.correlate(m); //메인 쿼리의 별칭을 가져옴. correlate를 사용해야 서브쿼리에서 메인쿼리의 별칭 사용 가능

        Join<Member, Team> t = subM.join("team");
        subQuery.select(t).where(cb.equal(t.get("name"), "팀A"));

        //메인 쿼리 생성
        mainQuery.select(m).where(cb.exists(subQuery));

        List<Member> resultList = em.createQuery(mainQuery).getResultList();

    }

    //IN
    public void ex10_70(){
        /**
         * JPQL
         *  select m from Member m
         *  where m.username in ("회원1", "회원2")
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);
        cq.select(m)
                .where(cb.in(m.get("username"))
                        .value("회원1")
                        .value("회원2"));

    }
    //CASE
    public void ex10_71() {
        /**
         * JPQL
         *  select m.username,
         *      case when m.age >= 60 then 600
         *           when m.age <= 15 then 500
         *           else 1000
         *      end
         *  from Member m
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        cq.multiselect(
                m.get("username"),
                cb.selectCase()
                        .when(cb.ge(m.<Integer>get("age"), 60), 600)
                        .when(cb.le(m.<Integer>get("age"), 15), 500)
                        .otherwise(1000)
        );

    }

    //파라미터 정의
    public void ex10_72(){
        /**
         * JPQL
         * select m from Member m
         * where m.username = :usernameParam
         */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> m = cq.from(Member.class);

        cq.select(m).where(cb.equal(m.get("username"), cb.parameter(String.class, "usernameParam")));
        List<Member> resultList = em.createQuery(cq)
                .setParameter("usernameParam", "회원1") //바인딩
                .getResultList();
    }

    //동적 쿼리
    public void ex10_73(){
        //검색 조건
        Integer age = 10;
        String username = null;
        String teamName = "팀A";

        //JPQL 동적 쿼리 생성
        StringBuilder jpql = new StringBuilder("select m from Member m join m.team t ");
        List<String> criteria = new ArrayList<>();

        if(age != null) criteria.add(" m.age = :age ");
        if(username != null) criteria.add(" m.username = :username ");
        if(teamName != null) criteria.add(" t.name = :teamName ");

        if(criteria.size() > 0) jpql.append(" where ");

        for(int i = 0 ; i < criteria.size(); i++){
            if(i > 0) jpql.append(" and ");
            jpql.append(criteria.get(i));
        }
        TypedQuery<Member> query = em.createQuery(jpql.toString(), Member.class);
        if( age != null) query.setParameter("age", age);
        if( username != null) query.setParameter("username", username);
        if( teamName != null) query.setParameter("teamName", teamName);

        List<Member> resultList = query.getResultList();

    }

    //Criteria 동적 쿼리
    public void ex10_74(){
        //검색 조건
        Integer age = 10;
        String username = null;
        String teamName = "팀A";

        //Criteria 동적 쿼리 생성
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        Join<Member, Team> t = m.join("team");

        List<Predicate> criteria = new ArrayList<>();

        if(age != null) {
            criteria.add(cb.equal(m.<Integer>get("age"), cb.parameter(Integer.class, "age")));
        }
        if(username != null){
            criteria.add(cb.equal(m.get("username"), cb.parameter(String.class, "username")));
        }
        if(teamName != null){
            criteria.add(cb.equal(t.get("teamName"), cb.parameter(String.class, "teamName")));
        }

        cq.where(cb.and(criteria.toArray(new Predicate[0])));


        TypedQuery<Member> query = em.createQuery(cq);
        if( age != null) query.setParameter("age", age);
        if( username != null) query.setParameter("username", username);
        if( teamName != null) query.setParameter("teamName", teamName);

        List<Member> resultList = query.getResultList();
    }



}
