package com.spring.webmvc.springmvc.board.domain;

import com.spring.webmvc.springmvc.chap02.domain.Grade;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    
    // 클라이언트가 전달할 데이터
    private String writer; // 작성자
    private String title; // 제목
    private String content; // 내용
    
    // 서버에서 생산하는 데이터
    private int boardNo; // 번호
    private int viewCount; // 조회수
    private String regDate; // 작성시간

    public Board(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        // 나머지 서버에서 생산하는 데이터
    }

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
//        this.content = rs.getString("content");
        this.viewCount = rs.getInt("view_cnt");
        this.regDate = rs.getString("reg_date");
    }
}
