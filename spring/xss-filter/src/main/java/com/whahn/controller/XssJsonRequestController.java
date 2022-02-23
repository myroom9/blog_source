package com.whahn.controller;

import com.whahn.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class XssJsonRequestController {
    @PostMapping("/json-content")
    @ResponseBody
    public Object jsonContent(@RequestBody RequestDto dto) {
        log.info("dto: {}", dto);

        return dto;
    }

    @GetMapping("/json-content")
    public String jsonContentPage() {

        return "json";
    }
}
