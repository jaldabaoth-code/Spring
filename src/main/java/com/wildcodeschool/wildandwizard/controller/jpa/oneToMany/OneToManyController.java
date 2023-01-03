package com.wildcodeschool.wildandwizard.controller.jpa.oneToMany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OneToManyController {
    @GetMapping("/jpa/one-to-many")
    public String index() {
        return "jpa/oneToMany/index";
    }
}
