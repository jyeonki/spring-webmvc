package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class SaveController implements ControllerV3 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {

        // 1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = paramMap.get("account");
        String password = paramMap.get("password");
        String userName = paramMap.get("userName");

        // 2. 회원 정보를 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
        repository.save(member);

        // 3. 홈 화면으로 이동 (redirection)
        // response.sendRedirect("/");

        return new ModelAndView("redirect:/");
    }
}
