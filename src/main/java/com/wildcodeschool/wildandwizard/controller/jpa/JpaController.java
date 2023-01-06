package com.wildcodeschool.wildandwizard.controller.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quests : JPA */
@Controller
public class JpaController {
    @GetMapping("/jpa")
    public String jpa() {
        return "jpa/index";
    }
}
