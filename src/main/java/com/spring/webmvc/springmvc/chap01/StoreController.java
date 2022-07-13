package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class StoreController {

    @RequestMapping("/store/form")
    public String form() {

        log.info("/store/form GET Request!!");

        return "chap01/store-form";
    }
}
