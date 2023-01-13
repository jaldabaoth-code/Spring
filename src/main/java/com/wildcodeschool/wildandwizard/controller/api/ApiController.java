package com.wildcodeschool.wildandwizard.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quests : API */
@Controller
public class ApiController {
    @GetMapping("/api")
    public String index() {
        return "/api/index";
    }
}
