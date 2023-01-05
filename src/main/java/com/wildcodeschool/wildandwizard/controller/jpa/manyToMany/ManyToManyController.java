package com.wildcodeschool.wildandwizard.controller.jpa.manyToMany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* JPA Quest : Many To Many */
@Controller
public class ManyToManyController {
    @GetMapping("/jpa/many-to-many")
    public String index() {
        return "jpa/manyToMany/index";
    }
}
