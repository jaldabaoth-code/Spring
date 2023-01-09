package com.wildcodeschool.wildandwizard.controller.jpa.jpaManyToMany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Many To Many */
@Controller
public class JpaManyToManyController {
    @GetMapping("/jpa/many-to-many")
    public String index() {
        return "/jpa/jpaManyToMany/index";
    }
}
