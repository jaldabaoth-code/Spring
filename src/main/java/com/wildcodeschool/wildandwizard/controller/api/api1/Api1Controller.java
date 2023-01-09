package com.wildcodeschool.wildandwizard.controller.api.api1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* API Quest : API 1 */
@Controller
public class Api1Controller {
    @GetMapping("/api/1")
    public String index() {
        return "api/api1/index";
    }
}
