package com.spring.webmvc.servlet.chap03.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// WEB-INF 폴더에 있는 reg-form.jsp를 열어주는 요청처리
@WebServlet("/mvc/join") // /앞에 안 붙이면 ./ 상대경로가 된다
public class JoinServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 물리적 경로
        String viewName = "/WEB-INF/views/reg_form.jsp";

        RequestDispatcher dp = req.getRequestDispatcher(viewName);
        dp.forward(req, resp);
    }
}
