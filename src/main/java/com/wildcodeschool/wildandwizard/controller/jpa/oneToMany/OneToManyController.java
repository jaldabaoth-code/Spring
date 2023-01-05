package com.wildcodeschool.wildandwizard.controller.jpa.oneToMany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* JPA Quest : One To Many */
@Controller
public class OneToManyController {
    @GetMapping("/jpa/one-to-many")
    public String index() {
        return "jpa/oneToMany/index";
    }
}
