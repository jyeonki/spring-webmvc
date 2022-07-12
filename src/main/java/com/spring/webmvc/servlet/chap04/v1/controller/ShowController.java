package com.spring.webmvc.servlet.chap04.v1.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowController implements ControllerV1 {
    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = repository.findAll();

        // Model : Controller & View 사이의 데이터(리스트)를 운반하는 수단 객체
        // - 여기서는 모델의 역할은 Request 객체가 담당
        request.setAttribute("mList", members); // request 객체에 데이터를 저장

        String viewName = "/WEB-INF/views/members.jsp";
        RequestDispatcher dp = request.getRequestDispatcher(viewName);
        dp.forward(request, response);
    }
}
