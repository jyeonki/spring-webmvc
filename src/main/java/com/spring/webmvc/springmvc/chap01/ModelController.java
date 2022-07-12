package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/model") // 공통처리
public class ModelController {
    
    // URL이 모여있어 관리가 편하다
    private static class ModelURL {
        public static final String HOBBIES = "/hobbies";
        public static final String HOBBIES2 = "/hobbies2";
        public static final String FORM = "/form";
        public static final String CHECK = "/age-check";
    }

    //=========== jsp 파일로 포워딩할 때 데이터 전달하기 ===========//
    
    //== 1. 모델 객체 사용하기
//    @RequestMapping("/model/hobbies")
//    @RequestMapping("/hobbies")
    @RequestMapping(ModelURL.HOBBIES)
    public String hobbies(Model model) {

        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("산책");
        hobbyList.add("뛰어놀기");
        hobbyList.add("밥먹기");
        hobbyList.add("낮잠자기");

        model.addAttribute("name", "멍멍이");
        model.addAttribute("hobbies", hobbyList);

        // /WEB-INF/views/hobbies.jsp
        return "chap01/hobbies";
    }

//    @RequestMapping("/model/hobbies2")
    @RequestMapping("/hobbies2")
    //== 2. ModelAndView 사용하기
    public ModelAndView hobbies2() {

        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("영화보기");
        hobbyList.add("맛집가기");
        hobbyList.add("낮잠자기");

        ModelAndView modelAndView = new ModelAndView("chap01/hobbies"); // /WEB-INF/views/hobbies.jsp
        modelAndView.addObject("name", "김지연");
        modelAndView.addObject("hobbies", hobbyList);

        return modelAndView;
    }

    // age-form 띄우기
//    @RequestMapping("/model/form")
    @RequestMapping("/form")
    public String form() {
        return "chap01/age-form";
    }

    // age 데이터 처리
//    @RequestMapping("/model/age-check")
    @RequestMapping("/age-check")
    public String check(int age, Model model) {

        // 나이로 출생년도 구하기 (한국나이)
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear);
        model.addAttribute("age", age);

        return "chap01/age-result";
    }

    //== 3. @ModelAttribute 사용
    // age 데이터 처리
//    @RequestMapping("/model/age-check2")
    @RequestMapping("/age-check2")
    public String check2(@ModelAttribute("age") int age, Model model) {

        // 나이로 출생년도 구하기 (한국나이)
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear);
//        model.addAttribute("age", age);

        return "chap01/age-result";
    }
}
