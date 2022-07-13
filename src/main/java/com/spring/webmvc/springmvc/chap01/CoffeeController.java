package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// ctrl + alt + o : 필요없는 import 구문 삭제

@Controller
@Log4j2
public class CoffeeController {

    // coffee form request
    @RequestMapping("/coffee/form")
    public String form() {

//        System.out.println("/coffee/form GET Request");
        log.info("/coffee/form GET Request"); // @Log4j2

        return "chap01/coffee-form";
    }

    // coffee order request
    @RequestMapping("/coffee/result")
    public String result(String menu, int price, Model model) {
        // @ModelAttribute("p") 대신 @ModelAttribute 이렇게만 적으면 price 로 넘어간다 ?????
        // controller 와 view 사이에서 데이터 전송하는 것은 model
        log.info("/coffee/result Post! - [" + menu + ", " + price + "]");

        model.addAttribute("menu", menu);
        model.addAttribute("p", price);

        return "chap01/coffee-result";
    }
}