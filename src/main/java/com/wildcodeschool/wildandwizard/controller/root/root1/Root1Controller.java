package com.wildcodeschool.wildandwizard.controller.root.root1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Root Quest : Root 1 */
@Controller
public class Root1Controller {
    @GetMapping("/root/root1")
    public String index() {
        return "root/root1/index";
    }
}
