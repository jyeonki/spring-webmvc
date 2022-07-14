package com.spring.webmvc.springmvc.chap02_1.repository;

import com.spring.webmvc.springmvc.chap02_1.domain.Score;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // @Component 개념
@RequiredArgsConstructor // final 필드를 초기화해주는 생성자 선언 (lombok)
@Log4j2
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
        String sql = "INSERT INTO tbl_score VALUES (seq_tbl_score.nextval, ?,?,?,?,?,?,?)";

        // INSERT, UPDATE, DELETE : 템플릿의  update() 메서드 활용
        return template.update(sql, score.getName(), score.getKor(), score.getEng(), score.getMath()
                , score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
        // 한 행을 삽입하는 거니까 == 1
    }

    /*public List<Score> findAll() {
        String sql = "SELECT * FROM tbl_score";

        // SELECT문의 경우는 query()
//        return template.query(sql, new ScoreRowMapper());

        *//*
        return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });
         *//*
        return template.query(sql, (rs, rowNum) -> new Score(rs));
    }*/
    @Override
    public List<Score> findAll(String sortingType) {

        /*StringBuilder sql = new StringBuilder("SELECT * FROM tbl_score");

        switch (sortingType) {
            case "num":
                sql.append(" ORDER BY stu_num");
                break;
            case "name":
                sql.append(" ORDER BY stu_name");
                break;
            case "average":
                sql.append(" ORDER BY average DESC");
                break;
        }*/

        log.info("ScoreRepositoryImpl.sortingType: '" + sortingType + "'");

        String orderBy = "";
        if ("stu_num".equals(sortingType)) {
            orderBy = " ORDER BY stu_num";
        } else if ("stu_name".equals(sortingType)) {
            orderBy = " ORDER BY stu_name";
        } else if ("KOR".equals(sortingType)) {
            orderBy = " ORDER BY KOR";
        } else if ("eng".equals(sortingType)) {
            orderBy = " ORDER BY eng";
        } else if ("math".equals(sortingType)) {
            orderBy = " ORDER BY math";
        } else if ("total".equals(sortingType)) {
            orderBy = " ORDER BY total";
        } else {
            orderBy = " ORDER BY average";
        }

        String sql = "SELECT * FROM tbl_score" + orderBy;
        log.info("ScoreRepositoryImpl.sql: " + sql);

        // SELECT문의 경우는 query()
//        return template.query(sql, new ScoreRowMapper());

        /*
        return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });
         */
        return template.query(sql, (rs, rowNum) -> new Score(rs));
    }

    @Override
    public Score findOne(int stuNum) {
        String sql = "SELECT * FROM tbl_score WHERE stu_num=?";
        // 단일 건수 조회시 사용

//        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);
        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum);
    }

    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num = ?";

        return template.update(sql, stuNum) == 1;
    }
}
