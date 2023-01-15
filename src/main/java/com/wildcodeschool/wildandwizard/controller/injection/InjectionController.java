package com.wildcodeschool.wildandwizard.controller.injection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quests : Injection */
@Controller
public class InjectionController {
    @GetMapping("/injection")
    public String index() {
        return "/injection/index";
    }
}
