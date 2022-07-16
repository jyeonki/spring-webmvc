package com.spring.webmvc.springmvc.board.repository;

import com.spring.webmvc.springmvc.board.domain.Board;
import com.spring.webmvc.springmvc.chap02.domain.Score;

import java.util.List;

public interface BoardRepository {

    // 글 저장
    boolean save(Board board);

    // 전체 목록 (content 제외)
    List<Board> findAll(String sort);

    // 개별 글 조회
    Board findOne(int boardNo);

    // 글 수정
    boolean modify(Board board);

    // 글 삭제
    boolean remove(int boardNo);

    // 조회수 카운트
    int updateViewCount(int boardNo);
}
