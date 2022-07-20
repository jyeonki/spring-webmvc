package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("학생의 점수 정보가 저장되어야 한다.")
    void saveTest() {

        Score score = new Score("김코히", 10, 20, 30);

        mapper.save(score);
        System.out.println(score);
    }

   /* @Test
    @DisplayName("전체 학생의 점수 정보가 조회되어야 한다.")
    void findAllTest() {

        mapper.findAll().forEach(System.out::println);
    }*/

    @Test
    @DisplayName("전체 학생의 점수 정보가 조회되어야 한다.")
    void findAllTest() {

        mapper.findAll("num").forEach(System.out::println);
    }

    @Test
    @DisplayName("학생 개인의 점수 정보가 조회되어야 한다.")
    void findOneTest() {

        Score score = mapper.findOne(25);
        System.out.println("score = " + score);
    }

    @Test
    @DisplayName("학생의 점수 정보가 삭제되어야 한다.")
    void removeTest() {

        boolean flag = mapper.remove(29);

        assertTrue(flag);
    }
}