package com.spring.webmvc.servlet.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("work 요청이 들어옴!");

        // 1. redirect : 재요청 --> 주소창 /jp/result.jsp
//        resp.sendRedirect("/jsp/result.jsp");
//        resp.sendRedirect("/info");
        
        // redirect, forward 동시에 쓰는 건 불가능
        
        // 2. forward : 강제 이동 --> 조소창 /work
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
        rd.forward(req, resp);
    }
}
