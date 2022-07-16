package com.spring.webmvc.springmvc.board.repository;

import com.spring.webmvc.springmvc.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryImplTest {

    @Autowired
    BoardRepository repository;

    @Test
    @DisplayName("글 정보가 데이터베이스 테이블에 잘 삽입되어야 한다.")
    void saveTest() {

        Board board = new Board("나간장", "나는 나간장", "나는 짜");

        boolean result = repository.save(board);

        assertTrue(result);
    }

    @Test
    @DisplayName("글번호에 해당하는 글이 데이터베이스 테이블에서 삭제되어야 한다.")
    void removeTest() {

        // given
        int boardNo = 1;

        // when
        boolean result = repository.remove(boardNo);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("글 목록이 조회되어야 한다.")
    void findAllTest() {
        List<Board> boardList = repository.findAll("no");

        boardList.forEach(System.out::println);

    }

    @Test
    @DisplayName("해당 글번호에 맞는 글정보가 나타나야 한다.")
    void findOneTest() {

        Board board = repository.findOne(2);

        System.out.println(board);

        assertEquals("진간장", board.getWriter());
    }

    @Test
    @DisplayName("글 정보가 수정되어야 한다.")
    void modifyTest() {

        // given
        int boardNo = 6;

        Board board = repository.findOne(boardNo);
        // findOne 먼저 생성하고 modify를 실시

        System.out.println(board);

        board.setWriter("김노트");
        board.setTitle("내 이름은 김노트");
        board.setContent("나에게 맘껏 적어줘");

        // when
        boolean result = repository.modify(board);

        // then
        Board newBoard = repository.findOne(boardNo);
        assertEquals("김노트", board.getWriter());
    }
}