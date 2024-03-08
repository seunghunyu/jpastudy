package com.study.jpastudy.save;

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


    }

}
