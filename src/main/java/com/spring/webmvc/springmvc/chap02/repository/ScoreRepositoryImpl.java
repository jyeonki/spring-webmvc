package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor // final 필드를 초기화해주는 생성자 선언 (lombok)
public class ScoreRepositoryImpl implements ScoreRepository {

    // 스프링 JDBC - JDBC Template : JDBC 단순화
    private final JdbcTemplate template;
    // final은 초기화가 되어있어야 한다

//    @Autowired
//    public ScoreRepositoryImpl(JdbcTemplate template) {
//        this.template = template;
//    } // -> @RequiredArgsConstructor

    @Override
    public boolean save(Score score) {
        return false;
    }

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public Score findOne(int stuNum) {
        return null;
    }

    @Override
    public boolean remove(int stuNum) {
        return false;
    }
}
