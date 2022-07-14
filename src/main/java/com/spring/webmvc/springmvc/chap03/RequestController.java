package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class RequestController {

    @RequestMapping("/req/hello")
    @ResponseBody
    public String hello() {
        log.info("/req/hello Request!!");
        return "hello";
    }

//    @RequestMapping(value = "/req/bye", method = RequestMethod.GET)
    @GetMapping("/req/bye") // = @RequestMapping(value = "/req/bye", method = RequestMethod.GET)
    @ResponseBody
    public String bye() {
        log.info("/req/bye GET Request!!");
        return "bye";
    }

    // url에서 파라미터 얻기
    @GetMapping("/member/{un}") // "/member/{un}/{}/{}" 여러개도 가능하다
    // a태그, 링크, 주소창으로 접근하면 무조건 Get
    @ResponseBody
    public String member(@PathVariable("un") String userName) {
        // @PathVariable : {un}을 String userName에 담는다
        // 이름이 같으면 @PathVariable만 적으면 된다
        return "I am " + userName;
    }
}
