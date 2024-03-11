package com.study.jpastudy.save;

import com.study.jpastudy.chapter7.ex7_6.Parent;
import com.study.jpastudy.chapter7.ex7_6.ParentId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
public class SaveTestEx7_6 {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Test
    void testSave() {
        Parent parent = new Parent();
        parent.setId1("myId1");
        parent.setId2("myId2");
        parent.setName("parentName");
        em.persist(parent);

        ParentId parentId = new ParentId("myId1","myId2");
        Parent findParent = em.find(Parent.class, parentId);
        log.info("findParentName =  {}" , findParent.getName());

    }

}
