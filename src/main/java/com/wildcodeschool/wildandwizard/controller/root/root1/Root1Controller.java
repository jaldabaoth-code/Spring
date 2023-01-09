package com.wildcodeschool.wildandwizard.controller.root.root1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Root 1 */
@Controller
public class Root1Controller {
    @GetMapping("/root/1")
    public String index() {
        return "root/root1/index";
    }
}
