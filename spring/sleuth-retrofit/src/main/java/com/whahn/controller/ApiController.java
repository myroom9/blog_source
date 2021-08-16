package com.whahn.controller;

import com.whahn.service.RetrofitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final RetrofitService retrofitService;

    @GetMapping("/test")
    public String test() throws IOException {
        log.info("client(A)에서 찍은 로그");
        retrofitService.apiTest();

        return "success";
    }
}
