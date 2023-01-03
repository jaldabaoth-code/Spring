package com.wildcodeschool.wildandwizard.controller.jpa.jpa1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Jpa1Controller {
    @GetMapping("/jpa/jpa1")
    public String index() {
        return "jpa/jpa1/index";
    }
}
