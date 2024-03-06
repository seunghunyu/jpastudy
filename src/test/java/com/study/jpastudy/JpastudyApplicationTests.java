package com.study.jpastudy;

import com.study.jpastudy.data.Member;
import com.study.jpastudy.data2.TMember;
import com.study.jpastudy.data2.Team;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpastudyApplicationTests {
	EntityManager em;
	@Test
	void contextLoads() {
	}

	@Test
	void joinTest(){
		Team team1 = new Team("team1", "팀1");
		em.persist(team1);

		TMember member1 = new TMember("member1", "회원1");
		member1.setTeam(team1);
		em.persist(member1);

		TMember member2 = new TMember("member2", "회원2");
		member2.setTeam(team1);
		em.persist(member2);


	}


}
