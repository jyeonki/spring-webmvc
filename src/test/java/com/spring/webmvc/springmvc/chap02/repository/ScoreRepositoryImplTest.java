package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트라인에서 사용 가능
class ScoreRepositoryImplTest {

    @Autowired // 테스트하게 주입 좀 해줘, ScoreRepositoryImpl에 빈 등록이 되어야 한다 (@Repository)
    ScoreRepository repository;

    @Test
    @DisplayName("점수 정보가 데이터베이스 테이블에 삽입되어야 한다.")
    void saveTest() {
        Score s = new Score("김딸기", 20, 12, 95);
        boolean result = repository.save(s);

        assertTrue(result);
    }

    @Test
    @DisplayName("특정 학번에 해당하는 점수 정보가 데이터베이스 테이블에서 삭제되어야 한다.")
    @Transactional
    @Rollback
    void removeTest() {

        // given
        int stuNum = 23;

        // when
        boolean result = repository.remove(stuNum);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("모든 점수 정보를 조회해야 한다.")
    void findAllTest() {

        List<Score> scoreList = repository.findAll();

        // 1
        scoreList.forEach(s -> System.out.println(s));
        // 2
//        scoreList.forEach(System.out::println);
        // 3
//        for (Score score : scoreList) {
//            System.out.println(score);
//        }
    }

    @Test
    @DisplayName("특정 학번에 대한 점수 정보를 조회해야 한다.")
    void findOneTest() {

        Score score = repository.findOne(5);

        System.out.println(score);

        assertEquals("김커피", score.getName());
    }
}