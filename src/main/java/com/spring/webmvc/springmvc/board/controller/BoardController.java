package com.spring.webmvc.springmvc.board.controller;

import com.spring.webmvc.springmvc.board.domain.Board;
import com.spring.webmvc.springmvc.board.repository.BoardRepository;
import com.spring.webmvc.springmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository repository;
    private final BoardService service;

    /*
     * 게시물 목록 요청: /board/list: GET
     * 게시물 상세조회 요청: /board/content: GET
     * 게시글 쓰기화면 요청: /board/write: GET
     * 게시글 등록 요청: /board/write: POST
     * 게시글 삭제 요청: /board/delete: GET
     * 게시글 수정화면 요청: /board/modify: GET
     * 게시글 수정 요청: /board/modify: POST
     */

    // 게시물 목록 요청
    @GetMapping("/board/list")
    public String list(Model model, @RequestParam(defaultValue = "no") String sort) {

        log.info("/board/list GET Request!!");
        log.info("/board/list GET Request!! - param1 : {}", sort);

        List<Board> boardList = repository.findAll(sort);

        model.addAttribute("boardList", boardList);
        return "chap02/board-list";
    }

    // 게시믈 상세 요청
    @GetMapping("/board/content")
    public ModelAndView content(int boardNo) {

        log.info("/board/content GET Request!! - param1: {}", boardNo);

        Board board = repository.findOne(boardNo);
        repository.updateViewCount(boardNo);

        ModelAndView mv = new ModelAndView("chap02/board-detail");
        mv.addObject("b", board);

        return mv;
    }

    // 게시글 쓰기 화면 요청
    @GetMapping("/board/write")
    public String write() {

        log.info("/board/write GET!!");

        return "chap02/board-write";
    }

    // 게시글 등록 요청
    @PostMapping("/board/write")
    public String post(Board board) {

        log.info("/board/write POST!!");

        return repository.save(board) ? "redirect:/board/list" : "redirect:/"; // 삼항 연산자
    }

    // 게시글 삭제 요청
    @GetMapping("/board/delete")
    public String delete(int boardNo) {

        log.info("/board/delete GET - param1: {}", boardNo); // sn이 {}안으로 들어간다

        return repository.remove(boardNo) ? "redirect:/board/list" : "redirect:/";
    }

    // 게시글 수정화면 요청: /board/modify - GET
    /*@GetMapping("/board/modify")
    public String viewModify(int boardNo, Model model) {

        log.info("/board/modify GET param1: {}", boardNo);

        Board board = repository.findOne(boardNo);
        model.addAttribute("b", board);

        return "chap02/board-modify";
    }*/

    // 게시글 수정화면 요청: /board/modify - GET
    @GetMapping("/board/modify")
    public ModelAndView viewModify(int boardNo) {

        log.info("/board/modify GET Request!! - param1: {}", boardNo);

        Board board = repository.findOne(boardNo);

        ModelAndView mv = new ModelAndView("chap02/board-modify");
        mv.addObject("b", board);

        return mv;
    }

    // 게시글 수정 요청: /board/modify - POST
    @PostMapping("/board/modify")
    public String modify(Board board) {

        log.info("/board/modify POST!!");
        return repository.modify(board) ? "redirect:/board/content?boardNo=" + board.getBoardNo() : "redirect:/board/list"; // 삼항 연산자
    }
}
