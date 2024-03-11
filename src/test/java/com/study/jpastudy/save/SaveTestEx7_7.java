package com.study.jpastudy.save;

import com.study.jpastudy.chapter7.ex7_7.ParentEm;
import com.study.jpastudy.chapter7.ex7_7.ParentEmId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SaveTestEx7_7 {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Test
    void testSave() {
        ParentEm parentEm = new ParentEm();
        ParentEmId parentEmId = new ParentEmId("myId1","myId2");
        parentEm.setId(parentEmId);
        parentEm.setName("parentName");
        em.persist(parentEm);

        ParentEmId parentEmId2 = new ParentEmId("myId1","myId2");
        ParentEm findParent = em.find(ParentEm.class, parentEmId);
        log.info("findParentName =  {}" , findParent.getName());

    }

}
