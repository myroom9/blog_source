package com.whahn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
// @CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    @GetMapping
    public String test(HttpServletResponse response) {
        log.info("요청 옴");

        //response.setHeader("Access-Control-Allow-origin", "*");
        //response.setHeader("Access-Control-Allow-Credentials", "true");

        return "redirect:http://localhost:9090";

        // return "success";
    }

    @PutMapping
    public String test1(HttpServletResponse response) {
        log.info("PUT 요청 옴");

        response.setHeader("Access-Control-Allow-origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return "success";
    }

}
