package com.whahn.controller;

import com.whahn.infra.FeignTest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final FeignTest feignTest;

    @GetMapping("/test")
    public String test() {
        feignTest.getTest();

        return "OK";
    }
}
