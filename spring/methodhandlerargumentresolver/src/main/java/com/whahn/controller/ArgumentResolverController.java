package com.whahn.controller;

import com.whahn.annotation.ClientIp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArgumentResolverController {

    @GetMapping("/")
    public String resolverTest(@ClientIp String clientIp) {
        log.info("clientIp: {}", clientIp);

        return "success";
    }
}
