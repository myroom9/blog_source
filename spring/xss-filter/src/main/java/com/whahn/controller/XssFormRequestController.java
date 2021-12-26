package com.whahn.controller;

import com.whahn.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class XssFormRequestController {
    @PostMapping("/form-content")
    public String formContent(RequestDto dto, RedirectAttributes r) {
        log.info("f dto: {}", dto);

        r.addAttribute("content", dto.getContent());

        return "redirect:/form-content";
    }

    @GetMapping("/form-content")
    public String formContentPage(RequestDto dto, Model model) {
        log.info("dto: {}", dto);

        model.addAttribute("content", dto.getContent());

        return "form";
    }
}
