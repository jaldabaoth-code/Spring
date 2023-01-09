package com.wildcodeschool.wildandwizard.controller.jpa.jpaOneToMany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : One To Many */
@Controller
public class JpaOneToManyController {
    @GetMapping("/jpa/one-to-many")
    public String index() {
        return "/jpa/jpaOneToMany/index";
    }
}
