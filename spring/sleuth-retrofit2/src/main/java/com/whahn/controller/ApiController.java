package com.whahn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

@Slf4j
@RestController
public class ApiController {
    @GetMapping("/test")
    public HashMap<String, String> test(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println("s = " + s);
            String header = request.getHeader(s);
            System.out.println("header = " + header);
        }
        log.info("server(B)에서 찍은 로그");
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("message", "success");
        return response;
    }
}
