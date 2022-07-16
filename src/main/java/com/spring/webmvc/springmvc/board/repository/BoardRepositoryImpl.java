package com.spring.webmvc.springmvc.board.repository;

import com.spring.webmvc.springmvc.board.domain.Board;
import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // final 필드를 초기화해주는 생성자 선언 (lombok)
@Log4j2
public class BoardRepositoryImpl implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public boolean save(Board board) {

        String sql = "INSERT INTO board VALUES (seq_board.nextval, ?,?,?,?, sysdate)";

        // INSERT, UPDATE, DELETE : 템플릿의  update() 메서드 활용
        return template.update(sql, board.getWriter(), board.getTitle(), board.getContent(), board.getViewCount()) == 1;
        // 한 행을 삽입하는 거니까 == 1
    }

    @Override
    public List<Board> findAll(String sort) {

//        String sql = "SELECT board_no, writer, title, view_cnt, reg_date FROM board";
//        return template.query(sql, (rs, rowNum) -> new Board(rs));

        StringBuilder sql = new StringBuilder("SELECT board_no, writer, title, content, view_cnt, reg_date FROM board");

        switch (sort) {
            case "no":
                sql.append(" ORDER BY board_no");
                break;

        }

        return template.query(sql.toString(), (rs, rowNum) -> new Board(rs));
    }

    @Override
    public Board findOne(int boardNo) {

        String sql = "SELECT * FROM board WHERE board_no=?";
        // 단일 건수 조회시 사용

        return template.queryForObject(sql, (rs, rowNum) -> new Board(rs), boardNo);
    }

    @Override
    public boolean modify(Board board) {

        String sql = "UPDATE board SET writer=?, title=?, content=? WHERE board_no=?";
//        String sql = "UPDATE board SET writer=1, title=1, content=1 WHERE board_no=3";

       return template.update(sql, board.getWriter(), board.getTitle(), board.getContent(), board.getBoardNo()) == 1;
    }

    @Override
    public boolean remove(int boardNo) {

        String sql = "DELETE FROM board WHERE board_no = ?";

        return template.update(sql, boardNo) == 1;
    }

    @Override
    public int updateViewCount(int boardNo) {

        String sql = "UPDATE board SET view_cnt = view_cnt + 1 WHERE board_no=?";

//        return BoardRepository.updateViewCount(boardNo); // static 문제
        return template.update(sql, boardNo);
    }
}
