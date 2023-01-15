package com.wildcodeschool.wildandwizard.controller.injection.injection1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Injection 1 */
@Controller
public class Injection1Controller {
    @GetMapping("/injection/1")
    public String index() {
        return "/injection/injection1/index";
    }
}
