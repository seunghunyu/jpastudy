package com.study.jpastudy;

import com.study.jpastudy.chapter4.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

//@SpringBootApplication
@EntityScan(basePackages = "com.study.jpastudy.chapter4")
public class JpastudyApplication {

	public static void main(String[] args) {
		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 API
		try{
			tx.begin(); //트랜잭션 시작
			logic(em); //비즈니스 로직 실행
			tx.commit(); //트랜잭션 커밋
		}catch(Exception e){
			System.out.println(e.toString());
			tx.rollback(); //예외발생 시 트랜잭션 롤백
		}finally{
			em.close();
		}
		emf.close();

		//SpringApplication.run(JpastudyApplication.class, args);
	}

	private static void logic(EntityManager em){
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("승훈");
		member.setAge(2);

		//등록
		em.persist(member);

		//수정
		member.setAge(20);

		//한 건 조회
		Member findMember = em.find(Member.class, id);
		System.out.println("findMember = " + findMember.getUsername()
		+", age="+findMember.getAge());

		List<Member> members
				= em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("members.size=" + members.size());

		//em.remove(member);


		id = "id2";
		Member member2 = new Member();
		member2.setId(id);
		member2.setUsername("승훈2");
		member2.setAge(22);

		//등록
		em.persist(member2);

	}


}
