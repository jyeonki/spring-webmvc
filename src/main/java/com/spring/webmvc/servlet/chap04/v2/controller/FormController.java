package com.spring.webmvc.servlet.chap04.v2.controller;

import com.spring.webmvc.servlet.chap04.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormController implements ControllerV2 {

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return new View("/WEB-INF/views/reg_form.jsp");
    }
}
