package com.spring.webmvc.servlet.chap03.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/save")
public class SaveServlet extends HttpServlet {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override // protected or public 가능 (오버라이딩 룰)
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");

        // 2. 회원 정보를 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
        repository.save(member);

        // 3. 홈 화면으로 이동 (redirection)
        response.sendRedirect("/");
    }
}
